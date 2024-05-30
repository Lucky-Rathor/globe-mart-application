package com.globe.mart.service;


import com.globe.mart.exception.ProductException;
import com.globe.mart.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    Product addProduct(Product product) throws ProductException;

    Product updateProduct(UUID productId,  Product product) throws ProductException;

    String deleteProductById(UUID productId) throws ProductException;

    Product getProductById(UUID productId) throws ProductException;

    List<Product> getAllProducts() throws ProductException;
}
