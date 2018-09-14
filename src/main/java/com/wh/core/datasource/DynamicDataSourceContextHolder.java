package com.wh.core.datasource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wang_hui
 * @date: 2018/9/13 下午2:47
 */
public class DynamicDataSourceContextHolder {
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public static List<Object> dataSourceKeys = new ArrayList<>();

    public static void setDataSourceLookupKey(String lookupKey) {
        CONTEXT_HOLDER.set(lookupKey);
    }

    public static String getDataSourceLookupKey() {
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSourceLookupKey() {
        CONTEXT_HOLDER.remove();
    }


}
