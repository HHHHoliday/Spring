package com.holidayX.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/t1")
    public String test(){
        System.out.println("testController执行了");
        return "ok";
    }
}
