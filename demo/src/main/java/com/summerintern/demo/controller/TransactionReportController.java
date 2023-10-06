package com.summerintern.demo.controller;


import com.summerintern.demo.model.TransactionReport;

import com.summerintern.demo.service.TransactionReportServiceImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionReportController {

    @Autowired
    private TransactionReportServiceImp transactionReportServiceImp;

    @GetMapping("/getAllTransactionReport")
    public List<TransactionReport> GetAllTransactionReport(){
        return transactionReportServiceImp.getAllTransactionReport();
    }

    @PostMapping("/AddTransactionReport")
    public TransactionReport CreateTransactionReport(@RequestBody TransactionReport transactionReport)
    {
        return transactionReportServiceImp.createTransactionReport(transactionReport);
    }

    @Transactional
    @PostMapping("/getTransactionReportById")
    public TransactionReport getTransactionReportById(@RequestBody TransactionReport transactionReport){
        System.out.println(transactionReportServiceImp.getTransactionReportById(transactionReport));
        return transactionReportServiceImp.getTransactionReportById(transactionReport);
    }

}
