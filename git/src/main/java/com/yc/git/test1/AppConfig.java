package com.yc.git.test1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // 配置类（这个类也会被spring创建）  声明容器运行时的一些配置信息（1.扫描的路径，这个路径所有带有@Component..）
@ComponentScan(basePackages = "com.yc.git.test1")  // 指定spring容器扫描类的路径
public class AppConfig {

}
