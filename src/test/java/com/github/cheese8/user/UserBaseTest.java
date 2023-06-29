package com.github.cheese8.user;

import com.github.cheese8.dbunit.DataSourceUtil;
import com.github.cheese8.dbunit.SimpleXmlDataSetLoader;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class,
        MockitoTestExecutionListener.class})
@Transactional(value = "transactionManagerUser")
@DbUnitConfiguration(databaseConnection = "dbunitDatabaseConnectionUser", dataSetLoader = SimpleXmlDataSetLoader.class)
public abstract class UserBaseTest {

    @Resource(name = "dataSourceUser")
    private DataSource dataSource;
}