package com.wh.core.datasource.properties;

import org.springframework.boot.context.properties.NestedConfigurationProperty;

import javax.sql.DataSource;

/**
 * 数据源属性
 *
 * @author: wang_hui
 * @date: 2018/9/13 下午7:31
 */
public class DataSourceProperty {
    /**
     * 连接池类型
     */
    private Class<? extends DataSource> type;

    private String driverClassName;

    private String url;

    private String username;

    private String password;

    /**
     * druid参数配置
     */
    @NestedConfigurationProperty
    private DruidDataSourceProperties druid = new DruidDataSourceProperties();
}
