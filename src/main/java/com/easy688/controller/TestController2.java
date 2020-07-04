package com.easy688.controller;

import com.easy688.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyuhui
 */
@Controller
public class TestController2 {
    private Integer num=0;
    private String version="3";
    static int number=0;
    @Resource
    private TestService testService;
    @GetMapping("/test2")
    @ResponseBody
    public String test(@RequestParam(value = "id") String id){
        System.out.println(id);
        return "success";
    }

    public static void main(String[] args) throws Exception{
        Lock lock=new ReentrantLock();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                lock.lock();
                try{
                for (int j = 0; j <100 ; j++) {
                        number++;
                    }
                }finally {
                        lock.unlock();
                    }
            }).start();

        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println(number);
        Semaphore semaphore=new Semaphore(3,false);
        System.out.println(semaphore);

    }
}
