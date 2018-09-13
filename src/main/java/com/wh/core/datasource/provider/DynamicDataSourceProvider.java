package com.wh.core.datasource.provider;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 多数据源加载接口
 *
 * @author: wang_hui
 * @date: 2018/9/13 下午5:33
 */
public interface DynamicDataSourceProvider {

    /**
     * 加载所有数据源
     *
     * @return 所有数据源，key为数据源名称
     */
    Map<String, DataSource> loadDataSources();
}
