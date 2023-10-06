package com.summerintern.demo.controller;


import com.summerintern.demo.model.Customer;

import com.summerintern.demo.service.CustomerServiceImp;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class CustomerController {

    @Autowired
    private CustomerServiceImp customerServiceImp;
    @GetMapping("/getAllCustomer")
    public List<Customer> GetAllCustomer(){
        return customerServiceImp.getAllCustomer();
    }

    // build create employee REST API
    @PostMapping("/AddCustomer")
    public Customer CreateCustomer(@RequestBody Customer customer)
    {
        return customerServiceImp.createCustomer(customer);
    }
    @Transactional
    @PostMapping("/getCustomerById")
    public Customer getCustomerById(@RequestBody Customer customer){
        System.out.println(customerServiceImp.getCustomerById(customer));
        return customerServiceImp.getCustomerById(customer);
    }
    @Transactional
    @PostMapping("/login")
    public String customer(@RequestBody Customer customer) {

        return customerServiceImp.existsByEmailandPassword(customer);
    }


}
