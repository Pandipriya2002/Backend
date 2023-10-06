package com.summerintern.demo.service;


import com.summerintern.demo.model.DeliveryDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface DeliveryDetailService {
    DeliveryDetail saveDeliveryDetail(DeliveryDetail delivery_detail);


    List<DeliveryDetailService> getAllDeliveryDetail();

    Optional<DeliveryDetail> getDeliveryDetailById(Integer delivery_id);

    List<DeliveryDetail> getAllDeliveryDetails();

    void deleteDeliveryDetail(Integer delivery_id);

    DeliveryDetail updateDeliveryDetail(Integer delivery_id, DeliveryDetail updatedDeliveryDetail);

}
