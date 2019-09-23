package com.psbc.canteen.common.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/**
 * <pre>
 * 功       能: 跨域
 * 涉及版本: V1.0.0
 * 创  建  者: zhangdd
 * 日       期: 2018年08月07日上午09:30:53
 * Q    Q: 540461328
 * </pre>
 */
@Configuration
public class CorsConfig {
    private final static Logger log = LoggerFactory.getLogger(CorsConfig.class);


    private CorsConfiguration buildConfig() {
        log.info("配置跨域");
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1 设置访问源地址
        corsConfiguration.addAllowedHeader("*"); // 2 设置访问源请求头
        corsConfiguration.addAllowedMethod("*"); // 3 设置访问源请求方法
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4 对接口配置跨域设置
        return new CorsFilter(source);
    }
}
