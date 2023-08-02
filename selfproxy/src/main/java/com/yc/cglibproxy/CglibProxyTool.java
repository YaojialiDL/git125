package com.yc.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyTool implements MethodInterceptor {

    private Object target;

    public CglibProxyTool(Object target) {
        this.target = target;
    }

    //生成代理对象
    public Object createProxy(){
        //Proxy.newProxyInstance(JdkProxyTool.class.getClassLoader(), target.getClass().getInterfaces(), this)
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        Object proxy = enhancer.create();
        return proxy;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if(method.getName().startsWith("add")){
            showHello(); // 前置增强
        }
        //                      orderBizImpl.findOrder()
        Object returnValue = method.invoke(target, args); // 调用目标类的方法
        return returnValue;
    }

    public void showHello(){
        System.out.println("hello...");
    }
}
