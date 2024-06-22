package com.insoft.price_calculation.controller;

import com.insoft.price_calculation.model.dto.OrderInfo;
import com.insoft.price_calculation.model.dto.ProductInfo;
import com.insoft.price_calculation.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MainController {

    private final OrderService orderService;

    @PostMapping("/calculate-price")
    public ResponseEntity<ProductInfo> calculatePrice(@RequestBody @Valid OrderInfo info) {
        return ResponseEntity.ok(orderService.calculatePrice(info));
    }

    @PostMapping("/purchase")
    public ResponseEntity<Boolean> purchase(@RequestBody @Validated(OrderInfo.Purchase.class) OrderInfo info) {
        return ResponseEntity.ok(orderService.purchase(info));
    }
}
