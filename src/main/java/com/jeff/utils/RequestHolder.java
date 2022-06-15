package com.jeff.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
/**
 * @ProjectName: joyy-backend
 * @Package: com.jeff.utils
 * @ClassName: RequestHolder
 * @Description: [获取 HttpServletRequest]
 * @Author: [clh]
 * @Date: 2022/6/15 20:35
 **/
public class RequestHolder {
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }
}
