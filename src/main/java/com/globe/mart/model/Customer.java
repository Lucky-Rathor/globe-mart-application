package com.globe.mart.model;


import lombok.*;



import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;
import java.util.UUID;


@Data
@Entity
public class Customer {

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
      private UUID customerId;

     @NotNull(message = "Customer name cannot be null")
     @Size(max = 50, min = 3)
     private String customerName;

     @NotNull(message = "Email is required")
     @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
     @Email
     private String customerEmail;

     @NotNull(message = "Password cannot be null!!")
     @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
     private String customerPassword;

     @OneToMany
     private List<Product> productList;




}
