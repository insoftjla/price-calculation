package com.insoft.price_calculation.processor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PaypalPaymentProcessorAdapter implements PaymentProcessor {

    private final PaypalPaymentProcessor paypalPaymentProcessor;

    @Override
    public String getName() {
        return "paypal";
    }

    @Override
    public boolean pay(Long price) {
        paypalPaymentProcessor.makePayment(price);
        return true;
    }
}
