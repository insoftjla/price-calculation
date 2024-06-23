package com.insoft.price_calculation.service;

import com.insoft.price_calculation.exception.AppException;
import com.insoft.price_calculation.model.Vat;
import com.insoft.price_calculation.model.dto.OrderInfo;
import org.springframework.stereotype.Service;

@Service
public class TaxService implements DiscountAndTaxesService {

    public Long apply(OrderInfo info, Long price) {
        var code = info.getTaxNumber().substring(0, 2);
        try {
            var vat = Vat.valueOf(code);
            return price + price * vat.getVat() / 100;
        } catch (IllegalArgumentException e) {
            throw new AppException("Tax number not supported");
        }

    }
}
