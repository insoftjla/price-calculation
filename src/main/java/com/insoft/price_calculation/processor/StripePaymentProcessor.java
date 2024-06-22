package com.insoft.price_calculation.processor;

import org.springframework.stereotype.Component;

@Component
public class StripePaymentProcessor {
    public boolean pay(float totalPrice) {
        return totalPrice >= 100;
    }
}
