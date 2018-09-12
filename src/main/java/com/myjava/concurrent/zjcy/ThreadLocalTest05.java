package com.myjava.concurrent.zjcy;

import com.myjava.collection.MyLinkedList;

import java.util.Random;

/**
 * Created by flyap on 2018/7/17.
 * 线程之间共享数据
 *
 *
 */
public class ThreadLocalTest05 {
    private  static  ThreadLocal<Integer> local=new ThreadLocal<Integer>();
    private static  ThreadLocal<MylocalData> mylocalDataThreadLocal=new ThreadLocal<MylocalData>();

public static void main(String[] args){

    for (int i = 0; i <2 ; i++) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int data=new Random().nextInt();
                System.out.println("put data"+data);
                local.set(data);
                MylocalData.getInstance().setAge(data);
                MylocalData.getInstance().setName("name"+data);
                ThreadLocalTest05.a();
                ThreadLocalTest05.b();
            }
        }).start();


    }

}


public  static  void  a(){
        int data=local.get();
        System.out.println("a form"+Thread.currentThread().getName()+data);
        MylocalData mylocalData=MylocalData.getInstance();
        System.out.println("a from MylocalData"+Thread.currentThread().getName()+mylocalData.getAge()+"   "+mylocalData.getName());
    }


    public  static  void  b(){
        int data=local.get();
        System.out.println("b form"+Thread.currentThread().getName()+data);
        MylocalData mylocalData=MylocalData.getInstance();
        System.out.println("b from MylocalData"+Thread.currentThread().getName()+mylocalData.getName()+"   "+mylocalData.getAge());
    }



}
class  MylocalData{
    private  int age;
    private  String name;
    private  static  ThreadLocal<MylocalData> map=new ThreadLocal<MylocalData>();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ThreadLocal<MylocalData> getMap() {
        return map;
    }

    public static void setMap(ThreadLocal<MylocalData> map) {
        MylocalData.map = map;
    }

    public MylocalData() {

    }

    public  static  MylocalData getInstance(){
        MylocalData instace=map.get();
        if(instace==null){
            instace=new MylocalData();
            map.set(instace);
        }
     return  instace;

    }
}