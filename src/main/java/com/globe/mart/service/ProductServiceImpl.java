package com.globe.mart.service;

import com.globe.mart.exception.ProductException;
import com.globe.mart.model.Product;
import com.globe.mart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) throws ProductException {
        if (product == null) {
            throw new ProductException("please provide all details to add product");
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(UUID productId, Product product) throws ProductException {

       Optional<Product> optionalProduct = productRepository.findById(productId);
       if (optionalProduct.isEmpty()) {
           throw new ProductException("product with this id:"+ productId + "does not exists");
       }
       return productRepository.save(product);
    }

    @Override
    public String deleteProductById(UUID productId) throws ProductException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new ProductException("product with this id:"+ productId + "does not exists");
        }
        productRepository.deleteById(productId);
        return "Product Deleted Successfully";
    }

    @Override
    public Product getProductById(UUID productId) throws ProductException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new ProductException("product with this id:"+ productId + "does not exists");
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() throws ProductException {
        List<Product> productList =productRepository.findAll();
        if (productList.isEmpty()) {
            throw new ProductException("No products added yet!...");
        }
        return productList;
    }
}
