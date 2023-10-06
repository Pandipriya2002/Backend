package com.summerintern.demo.controller;

import com.summerintern.demo.model.DeliveryDetail;
import com.summerintern.demo.service.DeliveryDetailServiceImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryDetailController {

    @Autowired
     DeliveryDetailServiceImp deliveryDetailServiceImp;
    @GetMapping("/getAllDeliveryDetail")
    public List<DeliveryDetail> GetAllDeliveryDetail(){
        return deliveryDetailServiceImp.getAllDeliveryDetails();
    }

    // build create employee REST API
    @PostMapping("/AddDeliveryDetail")
    public DeliveryDetail CreateDeliveryDetail(@RequestBody DeliveryDetail deliveryDetail)
    {
        return deliveryDetailServiceImp.createDeliveryDetail(deliveryDetail);
    }
    @Transactional
    @PostMapping("/getDeliveryDetailById")
    public DeliveryDetail getDeliveryDetailById(@RequestBody DeliveryDetail deliveryDetail){
        System.out.println(deliveryDetailServiceImp.getDeliveryDetailById(deliveryDetail));
        return deliveryDetailServiceImp.getDeliveryDetailById(deliveryDetail);
    }

}
