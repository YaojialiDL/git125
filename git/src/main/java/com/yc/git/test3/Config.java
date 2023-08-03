package com.yc.git.test3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.yc.git.test3.system","com.yc.git.test3.user"})
public class Config {
}
