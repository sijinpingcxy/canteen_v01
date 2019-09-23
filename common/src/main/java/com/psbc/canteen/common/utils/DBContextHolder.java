package com.psbc.canteen.common.utils;

import com.psbc.canteen.common.enumeration.DBTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * DBContextHolder
 *
 * @author zhangdd
 * @ClassName: DBContextHolder
 * @create 2019/8/26 9:28
 * @since 1.0.0
 */
public class DBContextHolder {
    private final static Logger log = LoggerFactory.getLogger(DBContextHolder.class);
    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbType) {
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get() {
        return contextHolder.get();
    }

    public static void master() {
        set(DBTypeEnum.MASTER);
        log.info("切换到写库master");
    }

    public static void slave() {
        set(DBTypeEnum.SLAVE);
        log.info("切换到读库slave");
    }
}