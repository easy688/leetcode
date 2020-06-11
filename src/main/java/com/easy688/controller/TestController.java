package com.easy688.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    private Integer num=0;
    private String version="1";
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        num++;
        return "success"+num+version;
    }
}
