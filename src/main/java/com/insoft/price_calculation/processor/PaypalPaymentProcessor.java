package com.insoft.price_calculation.processor;

import com.insoft.price_calculation.exception.AppException;
import org.springframework.stereotype.Component;

@Component
public class PaypalPaymentProcessor {
    public void makePayment(Long price) {
        if (price > 10000000) {
            throw new AppException("Price more 100000 not support");
        }
    }
}
