package com.jeff.service;

import com.jeff.domain.Report;
import com.jeff.service.dto.ReportDto;
import com.jeff.service.dto.ReportQueryCriteria;
import org.springframework.data.domain.Pageable;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ReportService {
    /**
     * 根据ID查询
     * @param id /
     * @return /
     */
    ReportDto findById(Long id);

    /**
     * 创建
     * @param resources /
     * @return /
     */
    void create(Report resources);

    /**
     * 编辑
     * @param resources /
     */
    void update(Report resources);

    /**
     * 删除
     * @param ids /
     */
    void delete(Set<Long> ids);

    /**
     * 分页查询
     * @param criteria 条件
     * @param pageable 分页参数
     * @return /
     */
    Map<String,Object> queryAll(ReportQueryCriteria criteria, Pageable pageable);

    /**
     * 查询全部数据
     * @param criteria /
     * @return /
     */
    List<ReportDto> queryAll(ReportQueryCriteria criteria);

//    /**
//     * 根据项目名搜索
//     * @param projName /
//     * @return /
//     */
//    List<Report> findByProjNames(String projName);

    /**
     * 根据项目名查询
     * @param projName 用户名
     * @return /
     */
    ReportDto findByProjName(String projName);


    /**
     * 导出数据
     * @param queryAll 待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<ReportDto> queryAll, HttpServletResponse response) throws IOException;

    /**
     * 验证是否被用户关联
     * @param reporterName /
     */
    void verification(String reporterName);
}

