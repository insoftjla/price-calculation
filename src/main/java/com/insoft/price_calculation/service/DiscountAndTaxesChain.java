package com.insoft.price_calculation.service;

import com.insoft.price_calculation.model.dto.OrderInfo;
import java.util.LinkedList;
import java.util.List;

public class DiscountAndTaxesChain {

    private DiscountAndTaxesChain() {
    }

    private final List<DiscountAndTaxesService> orderChains = new LinkedList<>();

    public Long apply(OrderInfo info, Long price) {
        Long result = price;
        for (DiscountAndTaxesService service : orderChains) {
            result = service.apply(info, result);
        }
        return result;
    }

    public static Builder builder() {
        return new DiscountAndTaxesChain().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder addChainLink(DiscountAndTaxesService service) {
            if (service == null) {
                throw new IllegalArgumentException("Chain link cannot be null");
            }
            DiscountAndTaxesChain.this.orderChains.add(service);
            return this;
        }

        public DiscountAndTaxesChain build() {
            return DiscountAndTaxesChain.this;
        }
    }
}
