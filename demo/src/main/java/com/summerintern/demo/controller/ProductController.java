package com.summerintern.demo.controller;


import com.summerintern.demo.model.Product;
import com.summerintern.demo.repositary.ProductRepository;
import com.summerintern.demo.service.ProductServiceImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/getAllProduct")
    public List<Product> GetAllProduct() {
        List<Product> products = productServiceImp.getAllProduct();
        for (Product product : products) {
            byte[] imageBytes = product.getProduct_image();
            if (imageBytes != null) {
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                product.setBase64Image(base64Image);
            } else {

            }
        }
        return products;

  }
    @PostMapping("/AddProduct")
    public Product CreateProduct(@RequestBody Product product)
    {

        return productServiceImp.createProduct(product);
    }



    @Transactional
    @GetMapping("/getProductById/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id){

        return productServiceImp.getProductById(id);
    }

}