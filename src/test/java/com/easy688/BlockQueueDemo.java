package com.easy688;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class BlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(4);
        //add 满了会抛出异常
        blockingQueue.add("1");
        blockingQueue.add("2");
        blockingQueue.add("3");
        blockingQueue.add("4");
        //blockingQueue.add("5");
        //检查队列空不空，获取队首元素
        System.out.println(blockingQueue.element());
        //remove 空了会抛出异常,先进先出
        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();
        //blockingQueue.remove();
        System.out.println(blockingQueue);
        BlockingQueue<String> blockingQueue2=new ArrayBlockingQueue<>(2);
        //offer添加成功返回true,队列满了之后再添加失败返回false，不会报异常
        System.out.println(blockingQueue2.offer("1"));
        System.out.println(blockingQueue2.offer("2"));
        System.out.println(blockingQueue2.offer("3"));
        System.out.println(blockingQueue2.offer("4"));
        //获取队首元素
        System.out.println(blockingQueue2.peek());
        //获取元素。没有元素返回null
        System.out.println(blockingQueue2.poll());
        System.out.println(blockingQueue2.poll());
        System.out.println(blockingQueue2.poll());
        System.out.println("blockingQueue2:"+blockingQueue2);
        BlockingQueue<String> blockingQueue3=new ArrayBlockingQueue<>(2);
        //put方法会在队列满了的时候一直阻塞，直到有元素被取出，可以插入
        blockingQueue3.put("1");
        blockingQueue3.put("2");
        //blockingQueue3.put("3");
        //take方法在队列空了的时候一直阻塞，直到有元素可以被取出
        blockingQueue3.take();
        blockingQueue3.take();
        //blockingQueue3.take();
        System.out.println(blockingQueue3);
        BlockingQueue<String> blockingQueue4=new ArrayBlockingQueue<>(2);
        //offer方法会在队列满了的时候一直阻塞，如果在规定的时间内还没有插入，就不等待了
        blockingQueue4.offer("1",2L, TimeUnit.SECONDS);
        blockingQueue4.offer("2",2L, TimeUnit.SECONDS);
        blockingQueue4.offer("3",2L, TimeUnit.SECONDS);
        //offer方法会在队列空了的时候一直阻塞，如果在规定的时间内还没有取到，就不等待了
        blockingQueue4.poll(2L, TimeUnit.SECONDS);
        blockingQueue4.poll(2L, TimeUnit.SECONDS);
        blockingQueue4.poll(2L, TimeUnit.SECONDS);
        BlockingQueue<String> synchronousQueue=new SynchronousQueue<>();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"put 1");
            try {
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"put 2");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"put 3");
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },Thread.currentThread().getName()).start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"take 1");
            try {
                TimeUnit.SECONDS.sleep(5);
                synchronousQueue.take();
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"take 2");
                synchronousQueue.take();
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"take 3");
                synchronousQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },Thread.currentThread().getName()).start();

    }
}
