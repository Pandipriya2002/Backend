package com.summerintern.demo.service;


import com.summerintern.demo.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    Order saveOrder(Order order_info);

    List<Order> getAllOrder();

    Optional<Order> getOrderById(Integer order_id);

    List<Order> getAllOrders();

    void deleteOrder(Integer order_id);

    Order updateOrder(Integer order_id, Order updatedOrder);

}
