package com.summerintern.demo.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;

@Data
@Entity
@Table(name = "order_info")

public class Order {
    @Basic
    @Id

    private Integer order_id;
    private Date order_date;
    private String order_status;
    private  Integer time_period;
    private Double total_amount;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer_details ;








}
