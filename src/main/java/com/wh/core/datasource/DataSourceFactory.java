package com.wh.core.datasource;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 数据源创建工厂类
 *
 * @author: wang_hui
 * @date: 2018/9/14 上午9:35
 */
public class DataSourceFactory {

    private static final String DRUID_DATASOURCE = "com.alibaba.druid.pool.DruidDataSource";

    /**
     * 创建数据源
     *
     * @param properties 数据源属性
     * @return 新创建的数据源
     */
    public static DataSource createDataSource(Properties properties) {
        String type = properties.getProperty("type");
        if (type == null) {
//            createDefaultDataSource(dataSourceProperty);
        } else if (DRUID_DATASOURCE.equals(type)) {
            return createDruidDataSource(properties);
        }
        return null;
    }

    public static DataSource createDruidDataSource(Properties properties) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.configFromPropety(properties);
        return dataSource;
    }
}
