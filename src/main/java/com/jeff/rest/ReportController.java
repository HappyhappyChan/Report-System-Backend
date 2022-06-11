package com.jeff.rest;

import com.jeff.service.ReportService;
import com.jeff.service.dto.ReportQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jeff.annotation.Log;
import com.jeff.exception.BadRequestException;
import com.jeff.domain.Report;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * @ProjectName: joyy-backend
 * @Package: com.jeff.rest
 * @ClassName: ReportController
 * @Description: []
 * @Author: [clh]
 * @Date: 2022/6/11 14:07
 **/

@RestController
@RequiredArgsConstructor
@Api(tags = "系统：报告管理")
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService reportService;
    private static final String ENTITY_NAME = "report";

    @ApiOperation("导出报告数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('report:list')")
    public void exportReport(HttpServletResponse response, ReportQueryCriteria criteria) throws IOException {
        reportService.download(reportService.queryAll(criteria), response);
    }

    @ApiOperation("查询项目名")
    @GetMapping
    @PreAuthorize("@el.check('report:list','user:list')")
    public ResponseEntity<Object> queryReport(ReportQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(reportService.queryAll(criteria, pageable),HttpStatus.OK);
    }

    @Log("新增报告")
    @ApiOperation("新增报告")
    @PostMapping
    @PreAuthorize("@el.check('report:add')")
    public ResponseEntity<Object> createReport(@Validated @RequestBody Report resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        reportService.create(resources);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Log("修改报告")
    @ApiOperation("修改报告")
    @PutMapping
    @PreAuthorize("@el.check('report:edit')")
    public ResponseEntity<Object> updateReport(@Validated(Report.Update.class) @RequestBody Report resources){
        reportService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除报告")
    @ApiOperation("删除报告")
    @DeleteMapping
    @PreAuthorize("@el.check('report:del')")
    public ResponseEntity<Object> deleteReport(@RequestBody Set<Long> ids){
//        // 验证是否被用户关联
//        reportService.verification(ids);
        reportService.delete(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
