package com.wh.core.datasource;

import com.wh.core.datasource.properties.DynamicDataSourceProperties;
import com.wh.core.datasource.provider.DynamicDataSourceProvider;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
@EnableConfigurationProperties(DynamicDataSourceProperties.class)
public class DataSourceConfigurer {

    private final DynamicDataSourceProperties properties;

    public DataSourceConfigurer(DynamicDataSourceProperties properties) {
        this.properties = properties;
    }

    @Bean(name = "dynamicDataSourceProvider")
    public DynamicDataSourceProvider dynamicDataSourceProvider() {
        return new DynamicDataSourceProvider(properties);
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DataSource dynamicDataSource(DynamicDataSourceProvider provider) {
        Map<String, DataSource> dataSourceMap = provider.loadDataSources();
        Map<Object, Object> targetDataSources = new HashMap<>();
        for (Map.Entry<String, DataSource> item : dataSourceMap.entrySet()) {
            targetDataSources.put(item.getKey(), item.getValue());
        }

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //将a_master数据源作为默认数据源
        dynamicDataSource.setDefaultTargetDataSource(targetDataSources.get(properties.getPrimary()));
        dynamicDataSource.setTargetDataSources(targetDataSources);

        //将所有数据源的key添加到数据源上下文key集合中，用户切换数据源时判断数据源是否有效
        DynamicDataSourceContextHolder.dataSourceKeys.addAll(dataSourceMap.keySet());

        return dynamicDataSource;
    }

}
