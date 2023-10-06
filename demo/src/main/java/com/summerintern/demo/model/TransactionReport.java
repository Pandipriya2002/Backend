package com.summerintern.demo.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "transaction_reports")
public class TransactionReport {
    @Basic
    @Id
    private Integer report_id;
    private Integer order_id;
    private Date transaction_date;
    private String transaction_type;
    private Double return_amount;
    private Double amount;

    public TransactionReport(Integer order_id, Date transaction_date, String transaction_type, Double return_amount, Double amount) {
        this.order_id = order_id;
        this.transaction_date = transaction_date;
        this.transaction_type = transaction_type;
        this.return_amount = return_amount;
        this.amount = amount;
    }
    public TransactionReport(){

    }
    public Integer getReport_id() {
        return report_id;
    }

    public void setReport_id(Integer report_id) {
        this.report_id = report_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public Double getReturn_amount() {
        return return_amount;
    }

    public void setReturn_amount(Double return_amount) {
        this.return_amount = return_amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
