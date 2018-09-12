package com.myjava.collection;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
//        DNMap<String, String> dnmap = new DNHashMap<String, String>();
//
//        Long t1 = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
//            dnmap.put("key" + i, "value" + i);
//        }
//
//        for (int i = 0; i < 10000; i++) {
//            System.out.println("key: " + "key" + i + "  value:"
//                    + dnmap.get("key" + i));
//        }
//        Long t2 = System.currentTimeMillis();
        //        System.out.println("jack写的dnhashMap耗时：" + (t2 - t1));
        //        System.out.println("-----------------------HashMap--------------------------");
        //
        //        Map<String, String> map = new HashMap<String, String>();
        //        Long t3 = System.currentTimeMillis();
        //        for (int i = 0; i < 1000; i++) {
        //            map.put("key" + i, "value" + i);
        //        }
        //
        //        for (int i = 0; i < 1000; i++) {
        //            System.out.println("key: " + "key" + i + "  value:"
        //                    + map.get("key" + i));
        //        }
        //        Long t4 = System.currentTimeMillis();
        //        System.out.println("jdk的hashMap耗时：" + (t4 - t3));

        try {
            Class dnmapClass = Class.forName("com.myjava.collection.HashMap");
            Field[] fieldArray = dnmapClass.getDeclaredFields();
            Arrays.stream(fieldArray).forEach(System.out::println);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}