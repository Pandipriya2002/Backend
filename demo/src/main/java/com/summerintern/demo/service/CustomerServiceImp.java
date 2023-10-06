package com.summerintern.demo.service;



import com.summerintern.demo.model.Customer;

import com.summerintern.demo.repositary.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return (List<Customer>) customerRepository.findAll();


    }

    public Customer getCustomerById(Customer customer) {
        return customerRepository.findById(customer.getCustomer_id()).get();
    }

    public Customer createCustomer(Customer customer) {
        customer.setCustomer_id(customerRepository.findMaxId() + 1);
        return customerRepository.save(customer);
    }

    public String existsByEmailandPassword(Customer customer) {
        if (customerRepository.existsByEmail(customer.getCustomer_mail()) > 0 ) {
            if (customerRepository.existsByPassword(customer.getCustomer_mail(), customer.getCustomer_password()) > 0) {

                List<Customer> user1 = customerRepository.findByEmail(customer.getCustomer_mail());

                System.out.println(user1.toString());

                String[] strArray = user1.toString().split(",");
                return "{ \"1\" : \"Logged in successfully\"}";
            }
            return "{ \"2\" : \"incorrect password\"}";
        }
        return "{ \"3\" : \"Email Id does not exist ;\"}" ;
    }

}
