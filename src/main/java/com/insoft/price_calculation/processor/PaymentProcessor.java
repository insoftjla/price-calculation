package com.insoft.price_calculation.processor;

public interface PaymentProcessor {

    String getName();

    boolean pay(Long price);
}
