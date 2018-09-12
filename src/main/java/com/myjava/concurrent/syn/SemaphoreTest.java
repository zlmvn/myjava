package com.myjava.concurrent.syn;

import javax.jnlp.ExtendedService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author flyap
 * @email 927840351@qq.com
 * @date 2018/9/11
 * @used
 */
public class SemaphoreTest {
    Semaphore  semaphore=new Semaphore(3);
     int i=0;

    public  void test(){
        try {
            semaphore.acquire();
            i++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + Thread.currentThread().getName() +
                        "进入，当前已有" + (3-semaphore.availablePermits()) + "个并发");
                try {
                    Thread.sleep((long)(Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() +
                        "即将离开");
                System.out.println("第"+i+"次调用");
                semaphore.release();

                //下面代码有时候执行不准确，因为其没有和上面的代码合成原子单元
                System.out.println("线程" + Thread.currentThread().getName() +
                        "已离开，当前已有" + (3-semaphore.availablePermits()) + "个并发");
            }


public static void main(String[] args){
    SemaphoreTest semaphoreTest=new SemaphoreTest();
    for(int i=0;i<100;i++){
     new Thread(new Runnable() {
         @Override
         public void run() {
             semaphoreTest.test();
         }
     }).start();
    }




}






}
