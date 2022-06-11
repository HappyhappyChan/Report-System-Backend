package com.jeff.domain;

import com.jeff.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name="sys_report")
public class Report extends BaseEntity implements Serializable {

    @Id
    @Column(name = "report_id")
    @NotNull(groups = Update.class)
    @ApiModelProperty(value = "报告表id", hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "proj_num")
    @NotNull
    @ApiModelProperty(value = "报告号")
    private Integer projNum;

    @Column(name = "proj_name")
    @NotBlank
    @ApiModelProperty(value = "项目名称")
    private String projName;

    @Column(name = "file_path")
    @NotNull
    @ApiModelProperty(value = "底稿路径")
    private String filePath;

    @Column(name = "module")
    @NotNull
    @ApiModelProperty(value = "对应模块")
    private String module;

    @Column(name = "sub_module")
    @NotNull
    @ApiModelProperty(value = "对应子模块")
    private String subModule;

    @Column(name = "audit_dept")
    @NotNull
    @ApiModelProperty(value = "被审计部门")
    private String auditDept;

    @Column(name = "rel_sys")
    @NotNull
    @ApiModelProperty(value = "涉及系统")
    private String relSys;

    @Column(name = "create_date")
    @ApiModelProperty(value = "启动日")
    private Date createDate;

    @Column(name = "finish_date")
    @ApiModelProperty(value = "完成日")
    private Date finishDate;

    @Column(name = "report_date")
    @ApiModelProperty(value = "报告日")
    private Date reportDate;

    @NotNull
    @ApiModelProperty(value = "缺陷数量")
    private Integer probNum;

    @ApiModelProperty(value = "备注")
    private String comments;

    @Column(name = "reporter_name")
    @NotBlank
    @ApiModelProperty(value = "报告人名")
    private String reporterName;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Report rep = (Report) o;
        return Objects.equals(id, rep.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}