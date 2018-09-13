package com.wh.core.datasource.properties;

import javax.sql.DataSource;

/**
 * @author: wang_hui
 * @date: 2018/9/13 下午7:38
 */
public class DruidDataSourceProperties {
    /**
     * 连接池类型
     */
    private Class<? extends DataSource> type;

    private String driverClassName;

    private String url;

    private String username;

    private String password;
}
