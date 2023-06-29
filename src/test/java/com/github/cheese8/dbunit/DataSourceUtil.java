package com.github.cheese8.dbunit;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.database.*;
import org.dbunit.dataset.csv.CsvDataSetWriter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.ext.mysql.MySqlMetadataHandler;

import javax.sql.DataSource;
import java.io.File;

public class DataSourceUtil {
    
    public static DatabaseDataSourceConnectionFactoryBean mySqlDatabaseDataSourceConnectionFactoryBean(DataSource dataSource, String schema) {
        DatabaseDataSourceConnectionFactoryBean factoryBean = new DatabaseDataSourceConnectionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setDatabaseConfig(mySqlDatabaseConfigBean());
        factoryBean.setSchema(schema);
        return factoryBean;
    }
    
    private static DatabaseConfigBean mySqlDatabaseConfigBean() {
        DatabaseConfigBean configBean = new DatabaseConfigBean();
        configBean.setAllowEmptyFields(true);
        configBean.setDatatypeFactory(new MySqlDataTypeFactory());
        configBean.setMetadataHandler(new MySqlMetadataHandler());
        return configBean;
    }
}