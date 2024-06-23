package com.insoft.price_calculation.validation;

import com.insoft.price_calculation.model.Vat;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class TaxNumberConstraintValidator implements ConstraintValidator<ValidTaxNumber, String> {

    @Override
    public boolean isValid(String taxNumber, ConstraintValidatorContext constraintValidatorContext) {
        if (taxNumber == null || taxNumber.isBlank()) {
            return true;
        }
        if (taxNumber.length() < 2) {
            return false;
        }

        var code = taxNumber.substring(0, 2);
        try {
            var vat = Vat.valueOf(code);
            return isMatches(taxNumber, vat.getPattern());
        } catch (IllegalArgumentException ignored) {
        }
        return false;
    }

    private boolean isMatches(String taxNumber, String regex) {
        return Pattern.compile(regex).matcher(taxNumber).matches();
    }
}
