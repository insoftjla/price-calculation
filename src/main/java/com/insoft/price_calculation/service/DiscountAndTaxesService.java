package com.insoft.price_calculation.service;

public interface DiscountAndTaxesService {
    Long apply(String key, Long price);
}
