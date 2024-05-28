package com.globe.mart.service;


import com.globe.mart.exception.ProductException;
import com.globe.mart.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product addProduct(Product product) throws ProductException;

    Product updateProduct(Product product) throws ProductException;

    String deleteProductById(Integer productId) throws ProductException;

    Product getProductById(Integer productId) throws ProductException;

    List<Product> getAllProducts() throws ProductException;
}
