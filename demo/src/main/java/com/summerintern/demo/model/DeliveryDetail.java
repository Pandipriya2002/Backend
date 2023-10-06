package com.summerintern.demo.model;

import jakarta.persistence.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "delivery_detail")

public class DeliveryDetail {
    @Id
    @Basic
    private Integer delivery_id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order_info ;


    @OneToOne
    @JoinColumn(name = "dm_id")
    private DeliveryMember delivery_members;



    private Date delivery_date;

    public DeliveryDetail(Integer order_id, Integer dm_id, Date delivery_date) {
        this.delivery_date = delivery_date;
    }
    public DeliveryDetail(){

    }

    public Integer getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(Integer delivery_id) {
        this.delivery_id = delivery_id;
    }

    public Order getOrder_info() {
        return order_info;
    }

    public void setOrder_info(Order order_info) {
        this.order_info = order_info;
    }

    public DeliveryMember getDelivery_members() {
        return delivery_members;
    }

    public void setDelivery_members(DeliveryMember delivery_members) {
        this.delivery_members = delivery_members;
    }


    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }
}
