package com.myjava.java8.atguigu.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.junit.Test;

/*
 * Java8 内置的四大核心函数式接口
 * 
 * Consumer<T> : 消费型接口
 * 		void accept(T t);
 * 
 * Supplier<T> : 供给型接口
 * 		T get(); 
 * 
 * Function<T, R> : 函数型接口
 * 		R apply(T t);
 * 
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 * 
 */
public class TestLambda3 {

    //Predicate<T> 断言型接口：
    @Test
    public void test4() {
        List<String> list = Arrays.asList("Hello", "atguigu", "Lambda", "www", "ok");
        List<String> strList = filterStr(list, (s) -> s.length() > 3);

        for (String str : strList) {
            System.out.println(str);
        }
    }

    //需求：将满足条件的字符串，放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();

        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }

        return strList;
    }

    //lianxi1 断言
    public List<Integer> filterInt(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> list1 = new ArrayList<>();
        for (Integer in : list) {
            if (predicate.test(in)) {
                list1.add(in);
            }
        }
        return list1;
    }

    //lianxi1 duanyan
    @Test
    public void lianxi1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 2, 3, 3, 8, 7, 5);
        List<Integer> list2 = filterInt(list, e -> e > 3);
        List<Integer> list3 = list2.stream().filter(e -> e > 3).collect(Collectors.toList());
        list2.stream().sorted().forEach(e -> System.out.println(e));
        System.out.println("_______________________");
        list3.stream().sorted().forEach(System.out::println);

    }

    //Function<T, R> 函数型接口：
    @Test
    public void test3() {
        String newStr = strHandler("\t\t\t 我大尚硅谷威武   ", (str) -> str.trim());
        System.out.println(newStr);

        String subStr = strHandler("我大尚硅谷威武", (str) -> str.substring(2, 5));
        System.out.println(subStr);
    }

    //需求：用于处理字符串
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    //Supplier<T> 供给型接口 :
    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));

        for (Integer num : numList) {
            System.out.println(num);
        }
    }

    //lianxi3
    public List<Integer> getNumListL(Integer e, Supplier<Integer> su) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int n = su.get();
            list.add(n);
        }
        return list;
    }
@Test
    public  void  lianxi3(){
        List<Integer> list=getNumListL(11,()->(int)( Math.random()*1000));
//        System.out.println((int)(Math.random())+"----------");
        list.stream().forEach(e->System.out.println(e));

    }
    //需求：产生指定个数的整数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }

        return list;
    }

    //Consumer<T> 消费型接口 :
    @Test
    public void test1() {
        happy(10000, (m) -> System.out.println("你们刚哥喜欢大宝剑，每次消费：" + m + "元"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }
}
