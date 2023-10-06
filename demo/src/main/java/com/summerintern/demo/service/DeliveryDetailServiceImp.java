package com.summerintern.demo.service;


import com.summerintern.demo.model.DeliveryDetail;
import com.summerintern.demo.repositary.DeliveryDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DeliveryDetailServiceImp {


    @Autowired
    DeliveryDetailRepository deliveryDetailRepository;

    public List <DeliveryDetail> getAllDeliveryDetails() {

        return deliveryDetailRepository.findAll();
    }
    public DeliveryDetail getDeliveryDetailById(DeliveryDetail deliveryDetail) {
      return deliveryDetailRepository.findById(deliveryDetail.getDelivery_id()).get();
    }
    public DeliveryDetail createDeliveryDetail(DeliveryDetail deliveryDetail) {
        deliveryDetail.setDelivery_id(deliveryDetailRepository.findMaxId() + 1);
        return deliveryDetailRepository.save(deliveryDetail);
    }
}