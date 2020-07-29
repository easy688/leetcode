package com.easy688.service;

import org.springframework.boot.ansi.AnsiOutput;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 逃逸分析测试
 */
public class EscspeAnalysisService {
    private static class Foo {
        private int x;
        private static int counter;
        public Foo() {
            x = (++counter);
        }
    }

    public static void main(String[] args)throws  Exception {
        CyclicBarrier   cb=new CyclicBarrier(3,()-> System.out.println("end"));
        for (int i = 0; i <3 ; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(finalI);

            }).start();
        }
        System.out.println("end");
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i <5; i++) {
            int temp=i;
            new Thread(()-> {
                try {
                    semaphore.acquire();
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("123"+temp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();

        }
 /*       long start = System.nanoTime();
        for (int i = 0; i < 1000 * 1000 * 10; ++i) {
            Foo foo = new Foo();
        }
        long end = System.nanoTime();
        System.out.println("Time cost is " + (end - start));*/
    }
}
