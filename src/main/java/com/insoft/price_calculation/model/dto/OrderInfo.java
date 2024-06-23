package com.insoft.price_calculation.model.dto;

import com.insoft.price_calculation.validation.ValidTaxNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderInfo {
    @NotNull
    private Integer product;
    @NotBlank
    @ValidTaxNumber
    private String taxNumber;
    private String couponCode;
    @NotBlank(groups = { Purchase.class })
    private String paymentProcessor;

    public interface Purchase {
    }
}
