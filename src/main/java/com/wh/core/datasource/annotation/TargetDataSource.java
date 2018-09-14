package com.wh.core.datasource.annotation;

import java.lang.annotation.*;

/**
 * 注解在类或方法上用来切换数据源
 *
 * @author: wang_hui
 * @date: 2018/9/14 上午11:57
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
