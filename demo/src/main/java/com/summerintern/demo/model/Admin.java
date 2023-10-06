package com.summerintern.demo.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "admin")
public class Admin {
       @Id
       @Basic

       private Integer admin_id;
       private String admin_name;
       private String admin_mail;
       private String admin_password;
}
