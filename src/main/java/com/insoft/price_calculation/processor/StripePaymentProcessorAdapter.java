package com.insoft.price_calculation.processor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StripePaymentProcessorAdapter implements PaymentProcessor {

    private final StripePaymentProcessor stripePaymentProcessor;

    @Override
    public String getName() {
        return "stripe";
    }

    @Override
    public boolean pay(Long price) {
        return stripePaymentProcessor.pay(price / 100F);
    }
}
