package com.globe.mart.controller;


import com.globe.mart.exception.ProductException;
import com.globe.mart.model.Product;
import com.globe.mart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductException {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping(value = "/product/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Integer productId) throws ProductException {
        return new ResponseEntity<>(productService.getProductById(productId),HttpStatus.OK);
    }

    @PutMapping(value = "/product/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws  ProductException {
        return new ResponseEntity<>(productService.updateProduct(product),HttpStatus.OK);
    }

    @DeleteMapping(value = "/product/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable("productId") Integer productId) throws ProductException {
        String message = productService.deleteProductById(productId);
        return new ResponseEntity<>(message,HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getAllProducts() throws ProductException {
       List<Product> productList = productService.getAllProducts();
       return new ResponseEntity<>(productList,HttpStatus.OK);
    }

}
