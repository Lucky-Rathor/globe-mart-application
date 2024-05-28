package com.globe.mart.service;


import com.globe.mart.exception.CustomerException;
import com.globe.mart.exception.ProductException;
import com.globe.mart.model.Customer;
import com.globe.mart.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

     Customer addCustomer(Customer customer) throws CustomerException;

     Customer updateCustomer(UUID customerId, List<Product> productList) throws CustomerException, ProductException;

     String deleteCustomerById(UUID customerId) throws CustomerException;

     Page<Customer> getAllCustomers() throws CustomerException;

     String login(String customerEmail, String customerPassword) throws CustomerException;




}
