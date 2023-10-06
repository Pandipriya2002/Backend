package com.summerintern.demo.service;


import com.summerintern.demo.model.Product;
import com.summerintern.demo.repositary.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return (List<Product>)productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {

        return  productRepository.findById(id);
    }
    public Product createProduct(Product product)
    {
        product.setProduct_id(productRepository.findMaxId() + 1);
        return productRepository.save(product);
    }
}
