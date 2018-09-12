package com.myjava.aop.cglib;

import org.junit.Test;

public class AOPTest {



    @Test
    public void proxyTest2() {
        CGlibProxyFactory factory = new CGlibProxyFactory();
        PersonServiceBean service = (PersonServiceBean) factory.createProxyInstance(new PersonServiceBean());
        service.save("999");
    }

}