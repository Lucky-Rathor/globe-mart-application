package com.globe.mart.service;


import com.globe.mart.exception.CustomerException;
import com.globe.mart.exception.ProductException;
import com.globe.mart.model.Customer;
import com.globe.mart.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {

     Customer addCustomer(Customer customer) throws CustomerException;

     Customer updateCustomer(Integer customerId, List<Product> productList) throws CustomerException, ProductException;

     String deleteCustomerById(Integer customerId) throws CustomerException;

     public Page<Customer> getAllCustomers() throws CustomerException;


}
