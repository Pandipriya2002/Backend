package com.summerintern.demo.controller;
import com.summerintern.demo.model.Order;
import com.summerintern.demo.service.OrderServiceImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin()
@RestController
public class OrderController {
    @Autowired
    private OrderServiceImp orderServiceImp;
    @GetMapping("/getAllOrder")
    public List<Order> GetAllOrder(){
        return orderServiceImp.getAllOrder();
    }


    // build create employee REST API
    @PostMapping("/AddOrder")
    public Order CreateOrder(@RequestBody Order order)
    {
        return orderServiceImp.createOrder(order);
    }
    @Transactional
    @PostMapping("/getOrderById")
    public Order getOrderById(@RequestBody Order order){
        System.out.println(orderServiceImp.getOrderById(order));
        return orderServiceImp.getOrderById(order);

    }

}
