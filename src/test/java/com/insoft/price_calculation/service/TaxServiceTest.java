package com.insoft.price_calculation.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxServiceTest {

    private TaxService taxService = new TaxService();

    @Test
    public void givenPrice_whenApplyTax_thenPriceEqualsExpectedValue() {
        // given
        var price = 10000L;

        // when
        var totalPrice = taxService.apply("GR123456789", price);

        // then
        assertEquals(12400, totalPrice);
    }
}