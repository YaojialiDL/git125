package com.yc.git.test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(value = "com.yc.git.test3")
public class Config {
    @Bean
    public ExecutorService threadPoolExecutor(){
        return new ThreadPoolExecutor(3, 5,
                0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), // 使用有界队列
                new ThreadPoolExecutor.DiscardPolicy());
    }
}
