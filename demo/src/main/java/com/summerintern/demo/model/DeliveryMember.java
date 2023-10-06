package com.summerintern.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
@Data
@Entity
@Table(name = "deliver")
public class DeliveryMember {
    @Id
    @Basic
    private Integer dm_id;
    private String dm_name;
    private String dm_mail;
    private String dm_password;
    private BigInteger dm_mobile;
    private String dm_address;
    private String dm_idproof;
}
