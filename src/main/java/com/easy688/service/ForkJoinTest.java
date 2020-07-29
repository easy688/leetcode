package com.easy688.service;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.stream.IntStream;

public class ForkJoinTest  extends RecursiveTask<Integer> {

    private int start;
    private int end;
    public ForkJoinTest(int start,int end){
        this.start=start;
        this.end=end;
    }
    @Override
    protected Integer compute() {
        if(end-start<10){
            return IntStream.rangeClosed(start,end).sum();
        }else{
            int mid=(start+end)/2;
            ForkJoinTest forkJoinTest1=new ForkJoinTest(start,mid);
            ForkJoinTest forkJoinTest2=new ForkJoinTest(mid+1,end);
            forkJoinTest1.fork();
            forkJoinTest2.fork();
            return forkJoinTest1.join()+forkJoinTest2.join();
        }
    }

    public static void main(String[] args)throws Exception {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask=forkJoinPool.submit(new ForkJoinTest(0,1000));
        System.out.println(forkJoinTask.get());
    }
}
