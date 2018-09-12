package com.myjava.concurrent.zjcy;

/**
 * Created by flyap on 2018/7/16.
 * 线程互斥
 */
public class TraditionalThreadSynchronized02 {

    public static void main(String[] args){
        TraditionalThreadSynchronized02 test=new TraditionalThreadSynchronized02();
        test.init();

    }

    private  void  init(){
        final Outputer outputer=new Outputer();
        new  Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("xianzai");
                }

            }
        }).start();

        new  Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output3("kaishi ");
                }

            }
        }).start();

    }

    static  class  Outputer{
        public  void  output(String name ){
            int len=name.length();
            synchronized (Outputer.class){
                for (int i = 0; i <len ; i++) {
                   System.out.println(name.charAt(i));
                }
                System.out.println();
            }
        }


        public  synchronized  void  output2(String name){
            int len=name.length();
            for (int i = 0; i <len ; i++) {
                System.out.println(name.charAt(i));
            }
            System.out.println();
        }
        public  static  synchronized  void  output3(String name){
            int len = name.length();
            for(int i=0;i<len;i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();


        }
    }






}
