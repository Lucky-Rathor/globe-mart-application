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

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Customer addCustomer(Customer customer) throws CustomerException {
        Optional<Customer> customerOptional = customerRepository.findById(customer.getCustomerId());
             if (ObjectUtils.isEmpty(customer.getCustomerName()) || customerOptional.isPresent()) {
                 throw new CustomerException("Please provide valid customer details");
             }
             return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Integer customerId, List<Product> productList) throws CustomerException, ProductException {
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
    public String deleteCustomerById(Integer customerId) throws CustomerException {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isEmpty()) {
            throw new CustomerException("customer with this id"+ customerId + " " +"does not exist! can't delete");
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
        return customerRepository.findAllByOrderByCustomerName(pageRequest);
    }

}
