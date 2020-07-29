package com.easy688.controller;

import com.easy688.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author liyuhui
 */
@Controller
public class TestController {
/*    private Integer num=0;
    private String version="4";
    @Resource
    private TestService testService;
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        num++;
        return "success"+num+"version:"+version;

    }*/
    @DeleteMapping
    public void test(){
        System.out.println("dev");
    }
}
