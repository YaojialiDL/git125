package com.yc.git.test2;

import java.util.Date;

public class Test01 extends Thread {

    public void run() {
        Date currentTime = new Date();
        System.out.println("Current time: " + currentTime);
    }

    public static void main(String[] args) {
        // 创建五个线程
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Test01();
            threads[i].start();
        }

        // 等待所有线程结束
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
