package com.myjava.concurrent.zjcy;

/**
 * Created by flyap on 2018/7/16.
 * 传统thread  方式
 */
public class TraditionalThread03 {



    public static void main(String[] args){
        Thread thread =new Thread(){
            public  void run(){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
              System.out.println(Thread.currentThread().getName()+"线程执行了");
            }



        };
        thread.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"线程执行了");
            }
        }).start();







        }
    }




