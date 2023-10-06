package com.summerintern.demo.repositary;


import com.summerintern.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("select coalesce(max(a.customer_id), 0) from Customer a")
    public Integer findMaxId();

    @Query(value = "select count(customer.customer_mail) from Customer customer where customer.customer_mail = ?1", nativeQuery = true)
    public int existsByEmail(String customer_mail);


    @Query(value = "select count(customer.customer_password) from Customer customer where customer.customer_mail = ?1 and customer.customer_password = ?2", nativeQuery = true)
    public int existsByPassword(String customer_mail, String customer_password);

    @Query(value = "select * from Customer customer where customer.customer_mail = ?1", nativeQuery = true)
    public List<Customer> findByEmail(String customer_mail);

}
