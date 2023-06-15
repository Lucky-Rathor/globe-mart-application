package com.globe.mart.model;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Product {

    @Id
    private Integer productId;

    private String productName;

    private double productPrice;
}
