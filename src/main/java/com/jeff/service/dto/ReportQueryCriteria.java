package com.jeff.service.dto;

import com.jeff.annotation.Query;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ProjectName: joyy-backend
 * @Package: com.jeff.service.dto
 * @ClassName: ReportQueryCriteria
 * @Description: []
 * @Author: [clh]
 * @Date: 2022/6/10 20:51
 **/
@Data
@NoArgsConstructor
public class ReportQueryCriteria {
    @Query(type = Query.Type.INNER_LIKE)
    private String projName;

    @Query(type = Query.Type.INNER_LIKE)
    private String reporterName;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
