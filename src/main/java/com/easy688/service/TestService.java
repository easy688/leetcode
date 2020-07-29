package com.easy688.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.*;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TestService {
    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10,new Thread(()->{
            System.out.println("end");
        }));
        for (int i = 0; i <10 ; i++) {
           new Thread(()->{
               try {
                   System.out.println(Thread.currentThread());
                   cyclicBarrier.await();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } catch (BrokenBarrierException e) {
                   e.printStackTrace();
               }
           }).start();
        }
    }

}
