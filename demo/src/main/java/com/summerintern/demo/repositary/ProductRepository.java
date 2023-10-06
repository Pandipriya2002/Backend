package com.summerintern.demo.repositary;

import com.summerintern.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("select coalesce(max(a.product_id), 0) from Product a")
    public Integer findMaxId();

}

