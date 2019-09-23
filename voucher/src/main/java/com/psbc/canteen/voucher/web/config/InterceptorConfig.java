package com.psbc.canteen.voucher.web.config;

import com.psbc.canteen.common.web.interceptor.ParamsValidInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 适配器
 *
 * @author zhangdd
 * @ClassName: InterceptorConfig
 * @create 2019/8/21 15:53
 * @since 1.0.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    /**
     * @description ： 配置拦截器
     * @param registry
     * @return ： void
     * @author : zhangdd
     * @since: 1.0.0
     * @date : 2019-08-22 12:02:16
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ParamsValidInterceptor())
                .addPathPatterns("/staff/findPage")
                .addPathPatterns("/terminalCall/channelGoodsList");
    }

    /**
     * @description ： 添加支持CORS跨域访问
     * @param registry
     * @return ： void
     * @author : zhangdd
     * @since: 1.0.0
     * @date : 2019-08-22 10:52:36
     */
    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
    }*/

}