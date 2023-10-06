package com.summerintern.demo.service;
import com.summerintern.demo.model.Order;
import com.summerintern.demo.repositary.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImp {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrder()
    {
        return (List<Order>)orderRepository.findAll();

    }
    public Order getOrderById(Order order) {
        return orderRepository.findById(order.getOrder_id()).get();
    }

    public Order createOrder(Order order) {
        order.setOrder_id(orderRepository.findMaxId()+1);
        return orderRepository.save(order);
    }
}
