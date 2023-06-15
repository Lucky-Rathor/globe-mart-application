package com.globe.mart.controller;



import com.globe.mart.exception.CustomerException;
import com.globe.mart.exception.ProductException;
import com.globe.mart.model.Customer;
import com.globe.mart.model.Product;
import com.globe.mart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/customer")
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) throws CustomerException {
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping(value = "/customer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody List<Product> productList) throws CustomerException, ProductException {
        return new ResponseEntity<>(customerService.updateCustomer(customerId,productList),HttpStatus.OK);
    }

    @DeleteMapping(value = "/customer/{customerId}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable("customerId") Integer customerId) throws CustomerException {
      String msg  = customerService.deleteCustomerById(customerId);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

}
