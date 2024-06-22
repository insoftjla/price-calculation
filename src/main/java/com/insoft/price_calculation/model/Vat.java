package com.insoft.price_calculation.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Vat {

    DE(19, "(DE)?[0-9]{9}"),
    IT(22, "(IT)?[0-9]{11}"),
    FR(20, "(FR)?[0-9A-Z]{2}[0-9]{9}"),
    GR(24, "(EL|GR)?[0-9]{9}");

    private final int vat;
    private final String pattern;

}