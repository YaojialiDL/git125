package com.yc.git.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        // 首先创建容器
        // ClassPathXmlApplicationContext 类路径下有一个xml文件来配置，来生成容器
        // FileSystemXmlApplicationContext FileSystem任意路径（c:/...）文件系统下的xml配置文件，来生成容器
        // AnnotationConfigApplicationContext 读取注解的类（@Configuration），生成容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 容器中已经创建好了这个类  “键：userDaoImpl”  值：是对象
        UserDao ud = (UserDao) ac.getBean("userDaoImpl");
        ud.add("李四");

        UserBiz ub = (UserBiz) ac.getBean("userBizImpl");
        ub.addUser("张三");
    }
}
