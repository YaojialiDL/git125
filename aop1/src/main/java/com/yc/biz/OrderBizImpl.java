package com.yc.biz;

import org.springframework.stereotype.Service;

@Service
public class OrderBizImpl implements OrderBiz {
    @Override
    public void makeOrder(int pid, int num) {
        if(num > 5){
            throw new RuntimeException("库存不足...");
        }
        System.out.println("makeOrder的方法调用：下订" + pid + "\t" + num);
    }

    @Override
    public int findOrderId(String pname) {
        System.out.println("findOrderId根据商品名：" + pname + "\t查找商品对应的订单号");
        return 2;
    }

    @Override
    public int findPid(String pname) {
        System.out.println("findPid根据商品名：" + pname + "\t查找商品对应的订单号");
        return (int) (Math.random() * 10);
    }
}
