package com.globe.mart.service;



import com.globe.mart.exception.CustomerException;
import com.globe.mart.exception.ProductException;
import com.globe.mart.model.Customer;
import com.globe.mart.model.Product;
import com.globe.mart.repository.CustomerRepository;
import com.globe.mart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Customer addCustomer(Customer customer) throws CustomerException {
        if (ObjectUtils.isEmpty(customer)) {
            throw new CustomerException("Please provide all valid customer details");
             }
             return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(UUID customerId, List<Product> productList) throws CustomerException, ProductException {
     Optional<Customer> customerOptional = customerRepository.findById(customerId);
     if (customerOptional.isEmpty()) {
         throw new CustomerException("customer with this id"+ customerId+" "+"does not exist");
     }
     if (productList.isEmpty()) {
         throw new ProductException("Product list is empty");
     }
        List<Product> newAddedProduct = new ArrayList<>();
        for (Product product: productList) {
            Optional<Product> newProduct = productRepository.findById(product.getProductId());
            if (newProduct.isEmpty()) {
                throw new CustomerException("product with id"+ product.getProductId()+" "+"does not exists");
            }
            newAddedProduct.add(newProduct.get());
            customerOptional.get().setProductList(newAddedProduct);
        }

     return customerRepository.save(customerOptional.get());
    }

    @Override
    @Transactional
    public String deleteCustomerById(UUID customerId) throws CustomerException {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isEmpty()) {
            throw new CustomerException("customer with this id"+" "+ customerId + " " +"does not exist! can't delete");
        }

         customerRepository.deleteById(customerId);
        return "Customer Deleted Successfully";
    }

    @Override
    public Page<Customer> getAllCustomers() throws CustomerException {
       List<Customer> customerList = customerRepository.findAll();
       if (customerList.isEmpty()) {
           throw new CustomerException("customer list is empty");
       }
        int pageNumber = 0;
        int pageSize = 10;
        Sort sort = Sort.by("customerName").ascending();

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        return customerRepository.findAll(pageRequest);
    }

    @Override
    public String login(String customerEmail, String customerPassword) throws CustomerException {
        if (customerEmail.isEmpty() || customerPassword.isEmpty()) {
            throw new CustomerException("Please provide required email and password");
        }
       Optional<Customer> customer =customerRepository.findCustomerByCustomerEmail(customerEmail);
        if (customer.isEmpty()){
            throw new CustomerException("User not exists...sign up first");
        }

        if(!customerPassword.equals(customer.get().getCustomerPassword()) || !customerEmail.equals(customer.get().getCustomerEmail())){
            throw new CustomerException("email or password is incorrect...please provide valid login credentials");
        }
        return "Customer login Successfully";
    }

}
