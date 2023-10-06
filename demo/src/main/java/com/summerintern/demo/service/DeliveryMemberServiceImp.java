package com.summerintern.demo.service;


import com.summerintern.demo.model.DeliveryMember;
import com.summerintern.demo.repositary.DeliveryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DeliveryMemberServiceImp {
    @Autowired
    private DeliveryMemberRepository deliveryMemberRepository;

    public List<DeliveryMember> getAllDeliveryMember() {
        return (List<DeliveryMember>) deliveryMemberRepository.findAll();
    }

    public DeliveryMember getDeliverMemberById(DeliveryMember deliver) {
        return deliveryMemberRepository.findById(deliver.getDm_id()).get();
    }

    public DeliveryMember createDeliveryMember(DeliveryMember deliver) {
        deliver.setDm_id(deliveryMemberRepository.findMaxId() + 1);
        return deliveryMemberRepository.save(deliver);
    }

    public String existsByEmailandPassword(DeliveryMember deliver) {
        if (deliveryMemberRepository.existsByEmail(deliver.getDm_mail()) > 0) {
          if (deliveryMemberRepository.existsByPassword(deliver.getDm_mail(), deliver.getDm_password()) > 0) {

                List<DeliveryMember> user1 = deliveryMemberRepository.findByEmail(deliver.getDm_mail());

                System.out.println(user1.toString());

                String[] strArray = user1.toString().split(",");
                return "{ \"1\" : \"Logged in successfully\"}";
            }
            return "{ \"2\" : \"incorrect password\"}";
        }
       return "{ \"3\" : \"Email Id does not exist ;\"}";
    }

}

