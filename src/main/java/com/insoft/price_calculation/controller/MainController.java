package com.insoft.price_calculation.controller;

import com.insoft.price_calculation.model.dto.OrderInfo;
import com.insoft.price_calculation.model.dto.ProductInfo;
import com.insoft.price_calculation.service.ProductPriceCalculationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MainController {

    private final ProductPriceCalculationService priceCalculationService;

    @PostMapping("/calculate-price")
    public ResponseEntity<ProductInfo> calculatePrice(@RequestBody @Valid OrderInfo info) {
        return ResponseEntity.ok(priceCalculationService.calculatePrice(info));
    }
}
