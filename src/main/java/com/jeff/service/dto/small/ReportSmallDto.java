package com.jeff.service.dto.small;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @ProjectName: joyy-backend
 * @Package: com.jeff.service.dto.small
 * @ClassName: ReportSmallDto
 * @Description: []
 * @Author: [clh]
 * @Date: 2022/6/10 20:15
 **/
@Data
@NoArgsConstructor
public class ReportSmallDto implements Serializable {

    private Long id;

    private String projName;

}
