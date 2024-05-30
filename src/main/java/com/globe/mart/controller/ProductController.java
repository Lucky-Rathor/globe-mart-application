package com.globe.mart.controller;


import com.globe.mart.exception.ProductException;
import com.globe.mart.model.Product;
import com.globe.mart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductException {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping(value = "/product/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") UUID productId) throws ProductException {
        return new ResponseEntity<>(productService.getProductById(productId),HttpStatus.OK);
    }

    @PutMapping(value = "/product/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") UUID productId,@RequestBody Product product) throws  ProductException {
        return new ResponseEntity<>(productService.updateProduct(productId,product),HttpStatus.OK);
    }

    @DeleteMapping(value = "/product/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable("productId") UUID productId) throws ProductException {
        String message = productService.deleteProductById(productId);
        return new ResponseEntity<>(message,HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getAllProducts() throws ProductException {
       List<Product> productList = productService.getAllProducts();
       return new ResponseEntity<>(productList,HttpStatus.OK);
    }

}
