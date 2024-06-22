package com.insoft.price_calculation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "product")
@Entity
public class Product {

    @Id
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Long price;
}
