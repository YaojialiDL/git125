package com.yc.git.test2;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test02 {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(3, 5,
                0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), // 使用有界队列
                new ThreadPoolExecutor.DiscardPolicy());

        for(int i = 0; i < 5; i ++){
            executorService.submit(()->{
                while (true){
                    Date d = new Date();
                    System.out.println(Thread.currentThread().getName() + "的时间为" + d);
                    Thread.sleep(1000);
                }
            });
        }

        //corePollSize + queue + maxi
        //3个线程 + 1任务不运行 + 1个新线程  => 4个线程
    }
}
