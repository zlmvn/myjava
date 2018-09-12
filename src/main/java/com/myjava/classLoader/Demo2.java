package com.myjava.classLoader;
/*
* 使用双亲委派模型的好处在于Java类随着它的类加载器一起具备了一种带有优先级的层次关系。
* 防止重复加载、父类已经加载过的，子类就不需要重复加载。否则会出现错误

2.3 JDK已有的类加载器

2.3.1 BootStrap Classloader ~~启动类加载器 - - - - -》 rt.jar（jdk/lib文件夹里面的jar）
2.3.2 Extension Classloader extends ClassLoader ~~ 扩展类加载器 - - - -》%JAVA%Home/lib/ext/*.jar
2.3.3 App Classloader Classloader extends ClassLoader ~~ 系统(应用)类加载器 - - - - -》ClassPath类
2.3.4 自定义类加载器extends ClassLoader - - - - - - 》完全自定义路径
【总结】2.3.4 的父加载器 是 2.3.3 ，2.3.3.的父加载器是2.3.2，2.3.2的父加载器是2.3.1.
*
* */
public class Demo2 {
    public static void main(String[] args) {
        ClassLoader loader = Demo2.class.getClassLoader();
        System.out.println("当前类的加载器"+loader);
        while(loader!=null) {
            System.out.println(loader);
            loader = loader.getParent();
        }
        System.out.println(loader);
    }
}