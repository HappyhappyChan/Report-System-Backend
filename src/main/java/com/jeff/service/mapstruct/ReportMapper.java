package com.jeff.service.mapstruct;

import com.jeff.base.BaseMapper;
import com.jeff.domain.Report;
import com.jeff.service.dto.ReportDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @ProjectName: joyy-backend
 * @Package: com.jeff.service.mapstruct
 * @ClassName: ReportService
 * @Description: []
 * @Author: [clh]
 * @Date: 2022/6/10 20:42
 **/
@Mapper(componentModel = "spring",uses = {DeptMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReportMapper extends BaseMapper<ReportDto, Report> {
}