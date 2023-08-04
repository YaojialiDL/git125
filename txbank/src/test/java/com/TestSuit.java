package com;

import com.yc.Test1;
import com.yc.Test2_DataSourceConfig;
import com.yc.dao.AccountDaoJdbcTemplateImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//Suite 测试套件
@RunWith(Suite.class)
@Suite.SuiteClasses({Test1.class, Test2_DataSourceConfig.class, AccountDaoJdbcTemplateImplTest.class})
public class TestSuit {
}
