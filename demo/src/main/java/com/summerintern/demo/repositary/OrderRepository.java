package com.summerintern.demo.repositary;

import com.summerintern.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Query("select coalesce(max(a.order_id), 0) from Order a")
    public Integer findMaxId();


}
