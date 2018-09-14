package com.wh.core.datasource.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.Ordered;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 动态数据源属性
 *
 * @author: wang_hui
 * @date: 2018/9/13 下午5:41
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "spring.datasource.dynamic")
public class DynamicDataSourceProperties {
    /**
     * 默认库
     */
    private String primary = "master";

    /**
     * 多数据源
     */
    private Map<String, Properties> datasource = new LinkedHashMap<>();

    /**
     * 多数据源选择算法clazz，默认负载均衡算法
     */

    /**
     * aop切面顺序，默认最高
     */
    private Integer order = Ordered.HIGHEST_PRECEDENCE;
}
