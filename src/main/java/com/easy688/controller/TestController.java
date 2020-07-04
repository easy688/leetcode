package com.easy688.controller;

import com.easy688.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

/**
 * @author liyuhui
 */
@Controller
public class TestController {
    private Integer num=0;
    private String version="4";
    @Resource
    private TestService testService;
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        num++;
        return "success"+num+"version:"+version;

    }
}
