package com.wh.core.datasource.provider;

import com.wh.core.datasource.DataSourceFactory;
import com.wh.core.datasource.properties.DynamicDataSourceProperties;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 多数据源加载
 *
 * @author: wang_hui
 * @date: 2018/9/13 下午5:33
 */
public class DynamicDataSourceProvider {

    private DynamicDataSourceProperties properties;

    public DynamicDataSourceProvider(DynamicDataSourceProperties properties) {
        this.properties = properties;
    }

    /**
     * 加载所有数据源
     *
     * @return 所有数据源，key为数据源名称
     */
    public Map<String, DataSource> loadDataSources() {
        Map<String, Properties> propertiesMap = properties.getDatasource();
        Map<String, DataSource> dataSourceMap = new HashMap<>(propertiesMap.size());
        for (Map.Entry<String, Properties> item : propertiesMap.entrySet()) {
            dataSourceMap.put(item.getKey(), DataSourceFactory.createDataSource(item.getValue()));
        }
        return dataSourceMap;
    }
}
