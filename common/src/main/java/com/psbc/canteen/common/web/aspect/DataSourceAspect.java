package com.psbc.canteen.common.web.aspect;

import com.psbc.canteen.common.utils.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 数据库读写设置路由key切面
 *
 * @author zhangdd
 * @ClassName: DataSourceAspect
 * @create 2019/8/26 9:30
 * @since 1.0.0
 */
@Aspect
@Component
public class DataSourceAspect {
    @Pointcut("!@annotation(com.psbc.canteen.common.utils.annotation.Master) " +
            "&& (execution(* com.psbc.canteen.*.service..*.select*(..)) " +
            "|| execution(* com.psbc.canteen.*.service..*.get*(..)))" +
            "|| execution(* com.psbc.canteen.*.service..*.find*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.psbc.canteen.common.utils.annotation.Master) " +
            "|| execution(* com.psbc.canteen.*.service..*.insert*(..)) " +
            "|| execution(* com.psbc.canteen.*.service..*.add*(..)) " +
            "|| execution(* com.psbc.canteen.*.service..*.update*(..)) " +
            "|| execution(* com.psbc.canteen.*.service..*.edit*(..)) " +
            "|| execution(* com.psbc.canteen.*.service..*.delete*(..)) " +
            "|| execution(* com.psbc.canteen.*.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }

}