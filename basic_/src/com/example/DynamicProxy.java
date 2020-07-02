package com.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object ret = method.invoke(target, args);
        after();
        return ret;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    public static void main(String[] args) {
        DynamicProxy dp = new DynamicProxy(new HelloImpl());
        IHello helloProxy = dp.getProxy();

        helloProxy.greeting();
    }
}

class HelloImpl implements IHello {
    public void greeting() {
        System.out.println("hi");
    }
}

interface IHello {
    void greeting();
}
