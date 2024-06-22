package com.insoft.price_calculation.service;

import com.insoft.price_calculation.exception.AppException;
import com.insoft.price_calculation.model.Vat;
import org.springframework.stereotype.Service;

@Service
public class TaxService implements DiscountAndTaxesService {

    public Long apply(String taxNumber, Long price) {
        var code = taxNumber.substring(0, 2);
        try {
            var vat = Vat.valueOf(code);
            return price + price * vat.getVat() / 100;
        } catch (IllegalArgumentException e) {
            throw new AppException("Tax number not supported");
        }

    }
}
