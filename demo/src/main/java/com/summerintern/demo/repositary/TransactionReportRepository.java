package com.summerintern.demo.repositary;

import com.summerintern.demo.model.TransactionReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionReportRepository extends JpaRepository<TransactionReport,Integer> {
    @Query("select coalesce(max(a.report_id), 0) from TransactionReport a")
    public Integer findMaxId();

}
