package com.myjava.java8.atguigus.java8;

import java.util.concurrent.RecursiveTask;

/**
 * Created by flyap on 2018/3/9.
 */
public class ForkJoinCalculateLianxi extends RecursiveTask<Long>{
/*
*
* */
private  long start;
private  long end;
private  static  final long THRESHOLD=10000L;//临界值

    public ForkJoinCalculateLianxi(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length=end-start;
        if(length<=THRESHOLD){
            long sum=0;
            for (long i=start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else{
           long middle =(start+end)/2;
           ForkJoinCalculateLianxi left=new ForkJoinCalculateLianxi(start,middle);
           left.fork();
            ForkJoinCalculateLianxi right=new ForkJoinCalculateLianxi(middle+1,end);
            right.fork();
            return  left.join()+right.join();
        }

    }
}
