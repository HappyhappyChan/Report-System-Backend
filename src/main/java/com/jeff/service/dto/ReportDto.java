package com.jeff.service.dto;

import com.jeff.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @ProjectName: joyy-backend
 * @Package: com.jeff.service.dto.small
 * @ClassName: ReportDto
 * @Description: []
 * @Author: [clh]
 * @Date: 2022/6/10 20:22
 **/

@Getter
@Setter
@NoArgsConstructor
public class ReportDto extends BaseDTO implements Serializable{

    private Long id;

    private Integer projNum;

    private String projName;

    private String filePath;

    private String module;

    private String subModule;

    private String auditDept;

    private String relSys;

    private Date createDate;

    private Date finishDate;

    private Date reportDate;

    private Integer probNum;

    private String comments;

    private String reporterName;

    public ReportDto(String projName, Long id) {
        this.projName = projName;
        this.id = id;
    }

}
