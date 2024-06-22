package com.insoft.price_calculation.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderInfo {
    private Long product;
    private String taxNumber;
    private String couponCode;
}
