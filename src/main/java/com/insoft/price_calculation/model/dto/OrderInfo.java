package com.insoft.price_calculation.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderInfo {
    @NotNull
    private Integer product;
    @NotNull
    private String taxNumber;
    private String couponCode;
}
