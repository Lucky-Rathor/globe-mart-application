package com.globe.mart.service;


import com.globe.mart.exception.CustomerException;
import com.globe.mart.model.Customer;
import com.globe.mart.repository.CustomerRepository;
import com.globe.mart.repository.ProductRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void addCustomerTest() throws CustomerException {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setCustomerName("test");
        Mockito.when(customerRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customer);

        Customer response = customerService.addCustomer(customer);
        Assertions.assertNotNull(response);
    }

    @Test(expected = CustomerException.class)
    public void addCustomerExceptionTest() throws CustomerException {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setCustomerName("test");
        Mockito.when(customerRepository.findById(Mockito.any())).thenReturn(Optional.of(customer));

        Customer response = customerService.addCustomer(customer);
        Assertions.assertNotNull(response);
    }

    @Test(expected = CustomerException.class)
    public void addCustomerException1Test() throws CustomerException {
        Customer customer = new Customer();
        customer.setCustomerId(1);
  //      customer.setCustomerName("test");
        Mockito.when(customerRepository.findById(Mockito.any())).thenReturn(Optional.of(customer));

        Customer response = customerService.addCustomer(customer);
        Assertions.assertNotNull(response);
    }

    @Test
    public void deleteCustomerByIdTest() throws CustomerException {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        Mockito.when(customerRepository.findById(Mockito.any())).thenReturn(Optional.of(customer));
        customerRepository.deleteById(Mockito.any());

        String msg = customerService.deleteCustomerById(1);
        Assertions.assertEquals("Customer Deleted Successfully",msg);
    }

    @Test(expected = CustomerException.class)
    public void deleteCustomerByIdExceptionTest() throws CustomerException {

        Mockito.when(customerRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        String msg = customerService.deleteCustomerById(Mockito.any());
        Assertions.assertNull(msg);

    }
}
