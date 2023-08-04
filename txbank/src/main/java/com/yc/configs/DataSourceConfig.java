package com.yc.configs;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
@Data
@Log4j2
@EnableTransactionManagement // 启用事务管理器
//@EnableAspectJAutoProxy // 启用动态代理机制
public class DataSourceConfig {
    //利用DI将db.properties中的内容注入
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driverclass}")
    private String driverclass;

    //以上的属性从db.properties中读取出来后，都存到了spring容器的Environment的变量（系统环境变量也在这里）

    @Value("#{ T(Runtime).getRuntime().availableProcessors()*2 }") // spEL表达式 -> spring expression language
    private int cpuCount;

    @Bean
    public TransactionManager dataSourceTransactionManager(@Autowired DataSource ds){
        DataSourceTransactionManager tx = new DataSourceTransactionManager();
        tx.setDataSource(ds);
        return tx;
    }

    // 参数：第三方的框架中的类  用@Bean托管
    @Bean(initMethod = "init",destroyMethod = "close") // DruidDataSource中提供了 init 初始化方法
    @Primary
    public DruidDataSource druidDataSource(){ // 另外要注意：idea会对这个方法的返回值进行解析，判断是否有init方法
        DruidDataSource dds = new DruidDataSource();
        dds.setUrl(url);
        dds.setUsername(username);
        dds.setPassword(password);
        dds.setDriverClassName(driverclass);
        //以上只是配置了参数，并没有创建联接池，在这个类的init()中完成了联接池创建
        //当前主机的cpu数*2
        //int cpuCount = Runtime.getRuntime().availableProcessors()*2;
        //log.info("配置druid的连接池大小：" + cpuCount);
        dds.setInitialSize(cpuCount);
        dds.setMaxActive(cpuCount * 2);
        return dds;
    }

    @Bean  // IOC注解，托管第三方
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverclass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public DataSource dbcpDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverclass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        //TODO:更多参数
        return dataSource;
    }
}
