package com.summerintern.demo.service;


import com.summerintern.demo.model.TransactionReport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TransactionReportService {
    TransactionReport saveTransactionReport(TransactionReport transactionReport);

    List<TransactionReport> getAllTransactionReport();

    Optional<TransactionReport> getTransactionReportById(Integer report_id);

    List<TransactionReport> getAllTransactionReports();

    void deleteTransactionReport(Integer report_id);

    TransactionReport updateTransactionReport(Integer report_id, TransactionReport updateTransactionReport);


}
