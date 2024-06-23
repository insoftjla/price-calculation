package com.insoft.price_calculation.service;

import com.insoft.price_calculation.model.dto.OrderInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxServiceTest {

    private TaxService taxService = new TaxService();

    @Test
    public void givenPrice_whenApplyTax_thenPriceEqualsExpectedValue() {
        // given
        var price = 10000L;
        var info = new OrderInfo();
        info.setTaxNumber("GR123456789");

        // when
        var totalPrice = taxService.apply(info, price);

        // then
        assertEquals(12400, totalPrice);
    }
}