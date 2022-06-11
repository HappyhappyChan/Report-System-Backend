package com.jeff.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: joyy-backend
 * @Package: com.jeff.annotation
 * @ClassName: Log
 * @Description: []
 * @Author: [clh]
 * @Date: 2022/6/11 14:18
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default "";
}
