package com.myjava.concurrent.zjcy;

/**
 * Created by flyap on 2018/7/17.
 *
 * 线程通信
 */
public class TraditionalThreadCommunication04 {

    public static void main(String[] args){
        final Business businus=new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    businus.mains(i);
                }
            }
        }).start();
      new Thread(new Runnable() {
          @Override
          public void run() {
              for (int i = 0; i <10; i++) {
                  businus.sub(i);
              }
          }
      }).start();

    }

}
    class  Business {
      private   Boolean aBoolean=true;
        /*
        * 如果主线程执行完毕开始执行子线程
        * */
        public  synchronized void sub(int i){
            while (!aBoolean){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int a = 0; a<10 ; a++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sub"+a);
            }
            aBoolean=false;
            this.notify();
        }
        /*
        * 主线程先执行执行完之后子线程执行
        * */
        public  synchronized  void  mains(int i){
            while (aBoolean){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            for (int j = 0; j <100 ; j++) {
                System.out.println("main"+j);
            }
           aBoolean=true;
            this.notify();

        }



    }

