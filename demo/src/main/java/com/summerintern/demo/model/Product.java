package com.summerintern.demo.model;

import jakarta.persistence.*;
import lombok.Data;
//import java.util.Optional;
@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @Basic

    private Integer product_id;
    private String product_name;
    private String product_category;
    private String product_description;
    private Double rent_amount;
    private Double deposit_amount;
    private String available_products;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Lob
    @Column(name = "product_image")
    private byte[] product_image;
    @Transient
    private String Base64Image;

}

