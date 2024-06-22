package com.insoft.price_calculation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductInfo {

    private String name;
    private Long totalPrice;
}
