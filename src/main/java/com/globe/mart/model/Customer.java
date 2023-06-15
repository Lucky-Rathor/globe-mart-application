package com.globe.mart.model;


import lombok.*;


import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


@Data
@Entity
public class Customer {

      @Id
      private Integer customerId;

     @NotNull(message = "Customer name cannot be null")
     @Size(max = 50, min = 3)
     private String customerName;

     @OneToMany
     private List<Product> productList;




}
