package com.easy688.learn;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest implements InvocationHandler {
    private TwoSumIntefer twoNumSum;
    public ProxyTest(TwoSumIntefer twoNumSum){
        this.twoNumSum=twoNumSum;
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("before-------------");
        method.invoke(twoNumSum,objects);
        System.out.println("after--------------");
        return null;
    }

    public static void main(String[] args) {
        TwoSumIntefer twoNumSum=new TwoNumSum();
        InvocationHandler proxyTest=new ProxyTest(twoNumSum);
        TwoSumIntefer  twoSum=(TwoSumIntefer)Proxy.newProxyInstance(proxyTest.getClass().getClassLoader(),twoNumSum.getClass().getInterfaces(),proxyTest);
        twoSum.printStr("123");

    }
}
