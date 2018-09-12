package com.myjava.concurrent.zjcy;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by flyap on 2018/7/16.
 */
public class TraditionalTimerTest01 {

    class  MyTask extends  TimerTask{

        @Override
        public void run() {
            System.out.println("121");
            new Timer().schedule(new MyTask(),100);
        }
    }
    public static void main(String[] args){
        TraditionalTimerTest01 test=new TraditionalTimerTest01();
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("334");

            }
        },1000);



    }




}
