package com.insoft.price_calculation.service;

import com.insoft.price_calculation.model.Coupon;
import com.insoft.price_calculation.model.CouponType;
import com.insoft.price_calculation.model.dto.OrderInfo;
import com.insoft.price_calculation.repository.CouponRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CouponServiceTest {

    @Mock
    private CouponRepository couponRepository;

    @InjectMocks
    private CouponService couponService;

    @Test
    public void givenPriceAndCoupon_whenApplyCoupon_thenPriceEqualsExpectedValue() {
        // given
        var price = 10000L;
        var info = new OrderInfo();
        info.setCouponCode("P15");

        when(couponRepository.findById(eq(info.getCouponCode()))).thenReturn(Optional.of(new Coupon(info.getCouponCode(), 15L, CouponType.PERCENT)));

        // when
        var totalPrice = couponService.apply(info, price);

        // then
        assertEquals(8500, totalPrice);
    }

    @Test
    public void givenPriceAndWithoutCoupon_whenApplyCoupon_thenPriceWillNotChanged() {
        // given
        var price = 10000L;

        // when
        var totalPrice = couponService.apply(new OrderInfo(), price);

        // then
        assertEquals(10000, totalPrice);
    }
}