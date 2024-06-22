package com.insoft.price_calculation.service;

import com.insoft.price_calculation.exception.AppException;
import com.insoft.price_calculation.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CouponService implements DiscountAndTaxesService {

    private final CouponRepository couponRepository;

    public Long apply(String couponCode, Long price) {
        if (couponCode == null) {
            return price;
        }
        var coupon = couponRepository.findById(couponCode).orElseThrow(() -> new AppException("Coupon not found"));
        return switch (coupon.getType()) {
            case PERCENT -> price - price * coupon.getValue() / 100;
            case DISCOUNT -> price - coupon.getValue();
        };
    }
}
