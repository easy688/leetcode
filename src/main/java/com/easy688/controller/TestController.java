package com.easy688.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    private Integer num;
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        num++;
        return "success"+num;
    }
}
