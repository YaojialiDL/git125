package com.yc.git.test4;

import com.yc.git.test4.user.BankAccount;
import com.yc.git.test4.user.BankAccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
//        DataSource ds = (DataSource) ac.getBean("myDataSource");
//
//        Connection con = ds.getConnection();
//        System.out.println(con);

        BankAccountDao bad = (BankAccountDao) ac.getBean("bankAccountDao");
        List<BankAccount> list = bad.findAll();
        for(BankAccount ba:list){
            System.out.println(ba);
        }
    }
}
