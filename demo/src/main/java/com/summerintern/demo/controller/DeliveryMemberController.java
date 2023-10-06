package com.summerintern.demo.controller;


import com.summerintern.demo.model.DeliveryMember;
import com.summerintern.demo.service.DeliveryMemberServiceImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController

public class DeliveryMemberController {
    @Autowired
    private DeliveryMemberServiceImp deliveryMemberServiceImp;
    @GetMapping("/getAllDeliver")
    public List<DeliveryMember> GetAllDeliveryMember(){
        return deliveryMemberServiceImp.getAllDeliveryMember();
    }

    // build create employee REST API
    @PostMapping("/AddDeliver")
    public DeliveryMember CreateDeliveryMember(@RequestBody DeliveryMember deliver)
    {
        return deliveryMemberServiceImp.createDeliveryMember(deliver);
    }

    @Transactional
    @PostMapping("/getDeliverById")
    public DeliveryMember getDeliveryMemberById(@RequestBody DeliveryMember deliver){
        System.out.println(deliveryMemberServiceImp.getDeliverMemberById(deliver));
        return deliveryMemberServiceImp.getDeliverMemberById(deliver);
    }
    @Transactional
    @PostMapping("/login2")
    public String deliver(@RequestBody DeliveryMember deliver) {

        return deliveryMemberServiceImp.existsByEmailandPassword(deliver);
    }
}
