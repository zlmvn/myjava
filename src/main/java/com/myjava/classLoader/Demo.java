//源码解释。debug的时候，先执行public static int tmp = 1;
//然后执行：static { .... }
//然后定位到Class Demo上
//最后再执行main方法。

//结论：初始化类，先加载static变量 + static{}语气，两者加载的顺序是按照你写的代码顺序加载的哦
package com.myjava.classLoader;
//源码解释。debug的时候，先执行public static int tmp = 1;
//然后执行：static { .... }
//然后定位到Class Demo上
//最后再执行main方法。
//结论：初始化类，先加载static变量 + static{}语气，两者加载的顺序是按照你写的代码顺序加载的哦
public class Demo {
    public static int tmp = 1;

    static {
        tmp = 2 ;
        System.out.println(tmp);
    }

    public static void main(String[] args) {
        tmp = 3 ; 
        System.out.println(tmp);
    }
}