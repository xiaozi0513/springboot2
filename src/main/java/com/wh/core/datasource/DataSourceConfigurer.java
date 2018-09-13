package com.wh.core.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数据源配置
 *
 * @author: wang_hui
 * @date: 2018/9/12 下午7:46
 */
@Configuration
public class DataSourceConfigurer {

    @Bean(name = "aMasterDataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.druid.a_master")
    public DataSource aMasterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "aSlave1DataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.druid.a_slave_1")
    public DataSource aSlave1DataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "aSlave2DataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.druid.a_slave_2")
    public DataSource aSlave2DataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "bMasterDataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.druid.b_master")
    public DataSource bMasterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DataSource dynamicDataSource() {
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceKey.A_MASTER.name(), aMasterDataSource());
        dataSourceMap.put(DataSourceKey.A_SLAVE_1.name(), aSlave1DataSource());
        dataSourceMap.put(DataSourceKey.A_SLAVE_2.name(), aSlave2DataSource());
        dataSourceMap.put(DataSourceKey.B_MASTER.name(), bMasterDataSource());

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //将a_master数据源作为默认数据源
        dynamicDataSource.setDefaultTargetDataSource(aMasterDataSource());
        dynamicDataSource.setTargetDataSources(dataSourceMap);

        //将所有数据源的key添加到数据源上下文key集合中，用户切换数据源时判断数据源是否有效
        DynamicDataSourceContextHolder.dataSourceKeys.addAll(dataSourceMap.keySet());

        return dynamicDataSource;
    }

}
