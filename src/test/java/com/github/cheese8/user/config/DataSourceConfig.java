package com.github.cheese8.user.config;

import com.github.cheese8.dbunit.DataSourceUtil;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Resource(name = "dataSourceUser")
    private DataSource dataSourceUser;
    
    @Bean(name = {"dbunitDatabaseConnectionUser"})
    public DatabaseDataSourceConnectionFactoryBean dbunitDatabaseConnectionUser() {
        return DataSourceUtil.mySqlDatabaseDataSourceConnectionFactoryBean(dataSourceUser, "user");
    }
}