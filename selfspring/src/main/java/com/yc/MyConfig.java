package com.yc;

import org.ycframework.annotion.YcComponentScan;
import org.ycframework.annotion.YcConfiguration;
import org.ycframework.annotion.YcRepository;

@YcConfiguration
@YcComponentScan(basePackages = "com.yc")
@YcRepository(value = "db.properties")
public class MyConfig {
}
