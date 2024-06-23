package com.insoft.price_calculation.service;

import com.insoft.price_calculation.model.dto.OrderInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;

@ExtendWith(MockitoExtension.class)
public class DiscountAndTaxesChainTest {

    @Mock
    private TaxService taxService;
    @Mock
    private CouponService couponService;

    @Test
    public void givenChain_whenApply_thenPerformInSequence() {
        // given
        var discountAndTaxesChain = DiscountAndTaxesChain.builder()
                .addChainLink(couponService)
                .addChainLink(taxService)
                .build();

        var orderInfo = new OrderInfo();
        orderInfo.setTaxNumber("DE1234567");
        orderInfo.setCouponCode("D10");

        // when
        discountAndTaxesChain.apply(orderInfo, 10000L);

        // then
        InOrder inOrder = Mockito.inOrder(taxService, couponService);
        inOrder.verify(couponService).apply(eq(orderInfo), anyLong());
        inOrder.verify(taxService).apply(eq(orderInfo), anyLong());
    }

}