package com.psbc.canteen.voucher.web;

import com.psbc.canteen.voucher.api.IConfigurationService;
import com.psbc.canteen.voucher.enums.ConfigurationEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description ：监听器TomcatListener
 * @author ：zhangdd
 */
@WebListener
public class TomcatListener implements ServletContextListener {

    private final static Logger log = LoggerFactory.getLogger(TomcatListener.class);
    @Autowired
    private IConfigurationService configurationService;

    private static ExecutorService es = null;
    /**
     * <pre>
     * 说       明: 设置线程池
     * 涉及版本: V1.0.0
     * 日       期: 2017年3月8日下午5:21:01
     * </pre>
     */
    public static ExecutorService getExecutorInstance() {
        if (es == null) {
            es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        }
        return es;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("---------------TOMCAT START!------------------------------------");
        try {
            ServletContext context = sce.getServletContext();
            /*ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            configurationService = (IConfigurationService) ctx.getBean("configurationService");
            if (this.configurationService.initData()) {// 配置表初始化数据功能
                log.info("---------------配置表初始化成功!------------------------------------");
                System.out.println(ConfigurationEnum.PAGE_SIZE.getKey()+"=>"+ConfigurationEnum.PAGE_SIZE.getValue());
            }*/
            context.setAttribute("version", System.currentTimeMillis());//资源文件版本号
            log.info("---------------启动成功!------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("---------------TOMCAT STOP!------------------------------------");
    }

}
