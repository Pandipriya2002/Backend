package com.summerintern.demo.service;


import com.summerintern.demo.model.TransactionReport;

import com.summerintern.demo.repositary.TransactionReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionReportServiceImp {
    @Autowired
    private TransactionReportRepository transactionReportRepository;

    public List<TransactionReport> getAllTransactionReport(){
        return (List<TransactionReport>)transactionReportRepository.findAll();
    }

    public TransactionReport getTransactionReportById(TransactionReport transactionReport) {
        return transactionReportRepository.findById(transactionReport.getReport_id()).get();
    }
    public TransactionReport createTransactionReport(TransactionReport transactionReport) {
        transactionReport.setReport_id(transactionReportRepository.findMaxId() + 1);
        return transactionReportRepository.save(transactionReport);
    }

}
