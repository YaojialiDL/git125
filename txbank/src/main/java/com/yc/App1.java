package com.yc;

import com.yc.biz.AccountBiz;
import com.yc.configs.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App1 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        AccountBiz ab = ac.getBean(AccountBiz.class);
        //ab.addAccount(1, 99);
    }
}
