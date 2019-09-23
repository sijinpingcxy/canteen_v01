package com.psbc.canteen.common.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.psbc.canteen.common.enumeration.DBTypeEnum;
import com.psbc.canteen.common.utils.MyRoutingDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * DataSourceConfig
 *
 * @author zhangdd
 * @ClassName: DataSourceConfig
 * @create 2019/8/26 9:24
 * @since 1.0.0
 */
@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.master.jdbc-url}")
    private String dbUrl;

    @Value("${spring.datasource.master.username}")
    private String username;

    @Value("${spring.datasource.master.password}")
    private String password;

    @Value("${spring.datasource.master.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.slave.jdbc-url}")
    private String dbUrl2;

    @Value("${spring.datasource.slave.username}")
    private String username2;

    @Value("${spring.datasource.slave.password}")
    private String password2;

    @Value("${spring.datasource.slave.driver-class-name}")
    private String driverClassName2;

    @Value("${spring.datasource.master.type}")
    private String dbType;

    @Value("${spring.datasource.druid.initial-size}")
    private int initialSize;

    @Value("${spring.datasource.druid.min-idle}")
    private int minIdle;

    @Value("${spring.datasource.druid.max-active}")
    private int maxActive;

    @Value("${spring.datasource.druid.query-timeout}")
    private int queryTimeout;

    @Value("${spring.datasource.druid.transaction-query-timeout}")
    private int transactionQueryTimeout;

    @Value("${spring.datasource.druid.remove-abandoned-timeout}")
    private int removeAbandonedTimeout;

    @Value("${spring.datasource.master.connectionProperties}")
    private String connectionProperties;

    @Value("${spring.datasource.slave.connectionProperties}")
    private String connectionProperties2;


    /*@Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }*/
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DruidDataSource masterDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setQueryTimeout(queryTimeout);
        datasource.setTransactionQueryTimeout(transactionQueryTimeout);
        datasource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        datasource.setConnectionProperties(connectionProperties);
        datasource.setDbType(dbType);
        return datasource;
    }

    /*@Bean
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }*/
    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    public DruidDataSource slaveDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dbUrl2);
        datasource.setUsername(username2);
        datasource.setPassword(password2);
        datasource.setDriverClassName(driverClassName2);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setQueryTimeout(queryTimeout);
        datasource.setTransactionQueryTimeout(transactionQueryTimeout);
        datasource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        datasource.setDbType(dbType);
        datasource.setConnectionProperties(connectionProperties2);
        return datasource;
    }

    @Bean
    public DataSource myRoutingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                          @Qualifier("slaveDataSource") DataSource slave1DataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.MASTER, masterDataSource);
        targetDataSources.put(DBTypeEnum.SLAVE, slave1DataSource);
        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();
        myRoutingDataSource.setDefaultTargetDataSource(masterDataSource);
        myRoutingDataSource.setTargetDataSources(targetDataSources);
        return myRoutingDataSource;
    }
}