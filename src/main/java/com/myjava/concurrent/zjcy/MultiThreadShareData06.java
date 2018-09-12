package com.myjava.concurrent.zjcy;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by flyap on 2018/7/17.
 * 线程之间共享数据
 *
 */
public class MultiThreadShareData06 {
//    private  static  int share=0;
    private static AtomicInteger integer=new AtomicInteger(0);

    public static void main(String[] args){
        MultiThreadShareData06 multiThreadShareData=new MultiThreadShareData06();
        for (int i = 0; i <2 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    multiThreadShareData.increment();
                    System.out.println("increment----"+integer);
                }
            }).start();
        }

       new Thread(new Runnable() {
           @Override
           public void run() {
               multiThreadShareData.decrement();
               System.out.println("decrement---"+integer);
           }
       }).start();

    }

    public  synchronized  void increment(){
        integer.incrementAndGet();
        System.out.println("increment"+integer);

    }

    public  synchronized  void decrement(){
        integer.decrementAndGet();
        System.out.println("decrement"+integer);
    }









}
