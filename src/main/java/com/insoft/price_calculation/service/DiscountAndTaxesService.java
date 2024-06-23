package com.insoft.price_calculation.service;

import com.insoft.price_calculation.model.dto.OrderInfo;

public interface DiscountAndTaxesService {

    Long apply(OrderInfo info, Long price);
}
