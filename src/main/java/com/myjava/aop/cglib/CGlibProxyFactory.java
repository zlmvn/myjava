package com.myjava.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibProxyFactory implements MethodInterceptor {
    private Object targetObject; // 代理的目标对象

    public Object createProxyInstance(Object targetObject) {
        this.targetObject = targetObject; 

        Enhancer enhancer = new Enhancer(); // 该类用于生成代理对象
        enhancer.setSuperclass(this.targetObject.getClass()); // 设置目标类为代理对象的父类
        enhancer.setCallback(this); // 设置回调用对象为本身

        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        PersonServiceBean bean = (PersonServiceBean)this.targetObject;
        Object result = null; 
        Logger.start();
        result = methodProxy.invoke(targetObject, args); // 把方法调用委派给目标对象
        Logger.end();
        return result;
    }
}