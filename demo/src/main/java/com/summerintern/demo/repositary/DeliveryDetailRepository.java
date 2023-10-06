package com.summerintern.demo.repositary;

import com.summerintern.demo.model.DeliveryDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface DeliveryDetailRepository extends JpaRepository<DeliveryDetail,Integer> {

    @Query("select coalesce(max(a.delivery_id), 0) from DeliveryDetail a")
    public Integer findMaxId();
}
