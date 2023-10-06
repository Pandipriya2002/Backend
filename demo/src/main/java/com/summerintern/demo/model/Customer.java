package com.summerintern.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
@Data
@Entity
@Table(name = "customer")
public class Customer {
@Id
@Basic
    private int customer_id;
    private String customer_name;
    private String customer_mail;
    private String customer_password;
    private BigInteger customer_mobile;
    private String customer_idproof;
    private String customer_address;
    private String reward_points;
    private String admin_verified;






}


