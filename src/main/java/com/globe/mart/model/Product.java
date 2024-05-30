package com.globe.mart.model;


import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    private UUID productId;

    @NotNull(message = "Product name cannot be null")
    private String productName;

    @NotNull(message = "Product price cannot be null")
    @Pattern(regexp = "^\\d+(,\\d{1,2})?$")
    private double productPrice;
}
