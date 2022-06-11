package com.jeff.repository;
import com.jeff.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ReportRepository extends JpaRepository<Report, Long>, JpaSpecificationExecutor<Report>{
    /**
     * 根据名称查询
     * @param projName 名称
     * @return /
     */
    Report findByProjName(String projName);

    /**
     * 根据Id删除
     * @param ids /
     */
    void deleteAllByIdIn(Set<Long> ids);

    /**
     * 根据报告人查询
     * @param reporterName /
     * @return /
     */
//    @Query(value = "SELECT count(1) FROM sys_report WHERE reporterName = ?1", nativeQuery = true)
    Report findByReporterName(String reporterName);
}
