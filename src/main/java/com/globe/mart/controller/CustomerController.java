package com.globe.mart.controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globe.mart.exception.CustomerException;
import com.globe.mart.exception.ProductException;
import com.globe.mart.model.Customer;
import com.globe.mart.model.Product;
import com.globe.mart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/register/customer")
    public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer) throws CustomerException {
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping(value = "/customer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody List<Product> productList) throws CustomerException, ProductException {
        return new ResponseEntity<>(customerService.updateCustomer(customerId,productList),HttpStatus.OK);
    }

    @DeleteMapping(value = "/customer/{customerId}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable("customerId") UUID customerId) throws CustomerException {
      String msg  = customerService.deleteCustomerById(customerId);
        return new ResponseEntity<>(msg,HttpStatus.NO_CONTENT);
    }

    @GetMapping("/customers")
    public ResponseEntity<Page<Customer>> getAllCustomers() throws CustomerException {
        return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody String request) throws CustomerException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(request);
        String customerEmail = jsonNode.get("customerEmail").asText();
        String customerPassword = jsonNode.get("customerPassword").asText();
        return new ResponseEntity<>(customerService.login(customerEmail,customerPassword),HttpStatus.OK);
    }

}
