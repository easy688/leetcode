package com.easy688;

import java.util.concurrent.atomic.AtomicInteger;

class Data{
    int number=0;
    public Data(){}
    public synchronized void  add(){
       number++;
    }
}
public class TestVoalite {
    public static void main(String[] args) {
        Data data=new Data();
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                for (int j = 0; j <2000 ; j++) {
                    data.add();
                }
            },String.valueOf(i)).start();
        }
        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println("threadName:"+Thread.currentThread().getName()+":"+data.number);
    }
}
