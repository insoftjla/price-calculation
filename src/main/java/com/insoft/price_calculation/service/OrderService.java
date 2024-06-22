package com.insoft.price_calculation.service;

import com.insoft.price_calculation.exception.AppException;
import com.insoft.price_calculation.model.dto.OrderInfo;
import com.insoft.price_calculation.model.dto.ProductInfo;
import com.insoft.price_calculation.processor.PaymentProcessor;
import java.util.Map;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ProductPriceCalculationService priceCalculationService;
    private final Map<String, PaymentProcessor> paymentProcessors;

    public OrderService(ProductPriceCalculationService priceCalculationService, @Qualifier("paymentProcessors") Map<String, PaymentProcessor> paymentProcessors) {
        this.priceCalculationService = priceCalculationService;
        this.paymentProcessors = paymentProcessors;
    }

    public ProductInfo calculatePrice(OrderInfo info) {
        return priceCalculationService.calculatePrice(info);
    }

    public boolean purchase(OrderInfo info) {
        if (!paymentProcessors.containsKey(info.getPaymentProcessor())) {
            throw new AppException(String.format("Processor %s not supported", info.getPaymentProcessor()));
        }

        var totalPrice = priceCalculationService.calculatePrice(info).getTotalPrice();
        return paymentProcessors.get(info.getPaymentProcessor()).pay(totalPrice);
    }
}
