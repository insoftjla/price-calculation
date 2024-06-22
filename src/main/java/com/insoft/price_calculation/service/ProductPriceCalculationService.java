package com.insoft.price_calculation.service;

import com.insoft.price_calculation.exception.AppException;
import com.insoft.price_calculation.model.dto.OrderInfo;
import com.insoft.price_calculation.model.dto.ProductInfo;
import com.insoft.price_calculation.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductPriceCalculationService {

    private final ProductRepository productRepository;
    private final TaxService taxService;
    private final CouponService couponService;

    public ProductInfo calculatePrice(OrderInfo info) {
        var product = productRepository.findById(info.getProduct()).orElseThrow(() -> new AppException("Product not found"));

        var priceWhitCoupon = couponService.apply(info.getCouponCode(), product.getPrice());
        var totalPrice = taxService.apply(info.getTaxNumber(), priceWhitCoupon);

        return new ProductInfo(product.getName(), totalPrice);
    }
}
