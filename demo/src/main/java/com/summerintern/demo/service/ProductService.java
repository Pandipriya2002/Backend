package com.summerintern.demo.service;


import com.summerintern.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    Product saveProduct(Product product);

    List<Product> getAllProduct();

    Optional<Product> getProductById(Integer product_id);

    List<Product> getAllProducts();

    void deleteProduct(Integer product_id);

    Product updateProduct(Integer product_id, Product updateProduct);

}
