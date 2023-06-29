package com.github.cheese8.user.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.github.cheese8.user.repository"}, sqlSessionFactoryRef = "sqlSessionFactoryUser")
public class UserDataSourceConfig {

    @Bean(name = {"dataSourcePropertiesUser"})
    @ConfigurationProperties(prefix = "spring.datasource.user")
    @Primary
    public DataSourceProperties datasourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = {"dataSourceUser"})
    @Primary
    public DataSource datasource(@Qualifier("dataSourcePropertiesUser") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = {"transactionManagerUser"})
    @Primary
    public PlatformTransactionManager transactionManager(@Qualifier("dataSourceUser") DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }

    @Bean(name = {"sqlSessionFactoryUser"})
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceUser") DataSource datasource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(datasource);
        sqlSessionFactory.setGlobalConfig(new GlobalConfig().setBanner(false));
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mappers/user/*Mapper.xml"));
        return sqlSessionFactory.getObject();
    }
}