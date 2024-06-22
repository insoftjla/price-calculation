package com.insoft.price_calculation;

import com.insoft.price_calculation.processor.PaymentProcessor;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(name = "paymentProcessors")
    public Map<String, PaymentProcessor> paymentProcessors(List<PaymentProcessor> processors) {
        return processors.stream().collect(Collectors.toMap(PaymentProcessor::getName, Function.identity()));
    }

}
