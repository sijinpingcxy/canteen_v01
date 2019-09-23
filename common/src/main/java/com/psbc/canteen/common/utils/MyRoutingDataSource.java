package com.psbc.canteen.common.utils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * MyRoutingDataSource
 * 获取路由key
 * @author zhangdd
 * @ClassName: MyRoutingDataSource
 * @create 2019/8/26 9:28
 * @since 1.0.0
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}