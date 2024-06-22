package com.insoft.price_calculation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppErrorMessage {
    private Integer code;
    private String message;
}
