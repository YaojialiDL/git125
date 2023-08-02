package com.yc.cglibproxy;


public class Test3 {
    public static void main(String[] args) {
        CglibProxyTool jpt = new CglibProxyTool(new OrderBizImpl());
        OrderBizImpl ob = (OrderBizImpl) jpt.createProxy();
        System.out.println("生成代理类对象：" + ob); // com.yc.staticproxy.OrderBizImpl@2f0e140b

        ob.findOrder();
        ob.addOrder(1, 99);
    }
}
