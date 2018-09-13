package com.wh.core.datasource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wang_hui
 * @date: 2018/9/13 下午2:47
 */
public class DynamicDataSourceContextHolder {
    //切换数据源时，保证不被其他线程修改
    private static Lock lock = new ReentrantLock();

    private static final ThreadLocal<Object> CONTEXT_HOLDER = new ThreadLocal<>();

    public static List<Object> dataSourceKeys = new ArrayList<>();


}
