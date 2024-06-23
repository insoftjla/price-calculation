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
    private final DiscountAndTaxesChain discountAndTaxesChain;

    public ProductInfo calculatePrice(OrderInfo info) {
        var product = productRepository.findById(info.getProduct()).orElseThrow(() -> new AppException("Product not found"));

        var totalPrice = discountAndTaxesChain.apply(info, product.getPrice());

        return new ProductInfo(product.getName(), totalPrice);
    }
}
