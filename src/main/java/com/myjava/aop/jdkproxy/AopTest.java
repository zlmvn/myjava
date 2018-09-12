package com.myjava.aop.jdkproxy;

import org.junit.Test;

/**
 * @author flyap
 * @email 927840351@qq.com
 * @date 2018/9/12
 * @used
 */
public class AopTest {

    @Test
    public void proxyTest() {
        JDKProxyFactory factory = new JDKProxyFactory();
        PeopleService service = (PeopleService) factory.createProxyInstance(new PeopleServiceBean());
        service.save("888");
    }


}
