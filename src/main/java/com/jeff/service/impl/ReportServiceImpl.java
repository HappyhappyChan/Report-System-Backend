package com.jeff.service.impl;

import lombok.RequiredArgsConstructor;
import com.jeff.exception.BadRequestException;
import com.jeff.exception.EntityExistException;
import com.jeff.domain.Report;
import com.jeff.repository.UserRepository;
import com.jeff.service.dto.ReportQueryCriteria;
import com.jeff.utils.*;
import com.jeff.repository.ReportRepository;
import com.jeff.service.ReportService;
import com.jeff.service.dto.ReportDto;
import com.jeff.service.mapstruct.ReportMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @ProjectName: joyy-backend
 * @Package: com.jeff.service.impl
 * @ClassName: ReportServiceImpl
 * @Description: []
 * @Author: [clh]
 * @Date: 2022/6/11 13:30
 **/
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "report")
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;
    private final RedisUtils redisUtils;
    private final UserRepository userRepository;

    @Override
    public Map<String,Object> queryAll(ReportQueryCriteria criteria, Pageable pageable) {
        Page<Report> page = reportRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(reportMapper::toDto).getContent(),page.getTotalElements());
    }

    @Override
    public List<ReportDto> queryAll(ReportQueryCriteria criteria) {
        List<Report> list = reportRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder));
        return reportMapper.toDto(list);
    }

    @Override
    public ReportDto findByProjName(String projName){
        Report report = reportRepository.findByProjName(projName);
        return reportMapper.toDto(report);
    }

    @Override
    @Cacheable(key = "'id:' + #p0")
    public ReportDto findById(Long id) {
        Report report = reportRepository.findById(id).orElseGet(Report::new);
        ValidationUtil.isNull(report.getId(),"Report","id",id);
        return reportMapper.toDto(report);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(Report resources) {
        Report report = reportRepository.findByProjName(resources.getProjName());
        if(report != null){
            throw new EntityExistException(Report.class,"name",resources.getProjName());
        }
        reportRepository.save(resources);
    }

    @Override
    @CacheEvict(key = "'id:' + #p0.id")
    @Transactional(rollbackFor = Exception.class)
    public void update(Report resources) {
        Report report = reportRepository.findById(resources.getId()).orElseGet(Report::new);
        Report old = reportRepository.findByProjName(resources.getProjName());
        if(old != null && !old.getId().equals(resources.getId())){
            throw new EntityExistException(Report.class,"name",resources.getProjName());
        }
        ValidationUtil.isNull( report.getId(),"Report","id",resources.getId());
        resources.setId(report.getId());
        reportRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        reportRepository.deleteAllByIdIn(ids);
        // 删除缓存
        redisUtils.delByKeys(CacheKey.REPORT_ID, ids);
    }

    @Override
    public void download(List<ReportDto> reportDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ReportDto reportDTO : reportDtos) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("报告号", reportDTO.getProjNum());
            map.put("项目名称", reportDTO.getProjName());
            map.put("底稿路径", reportDTO.getFilePath());
            map.put("对应模块", reportDTO.getModule());
            map.put("对应子模块", reportDTO.getSubModule());
            map.put("被审计部门", reportDTO.getAuditDept());
            map.put("涉及系统", reportDTO.getRelSys());
            map.put("启动日", reportDTO.getCreateDate());
            map.put("完成日", reportDTO.getFinishDate());
            map.put("报告日", reportDTO.getReportDate());
            map.put("缺陷数量", reportDTO.getProbNum());
            map.put("备注", reportDTO.getComments());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }


    public void verification(String reporterName) {
        if(reportRepository.findByReporterName(reporterName) != null){
            throw new BadRequestException("所选的岗位中存在用户关联，请解除关联再试！");
        }
    }
}
