package com.myjava.classLoader;
//这里需要我在D盘的temp文件夹中，新建一个Demo.java的类，然后进行编译
public class TestName {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        MyClassLoader loader = new MyClassLoader("xiaozheng", "D:/temp/");
        Class<?> c = loader.loadClass("Demo");
        c.newInstance();
        System.out.println("231231");
    }
}