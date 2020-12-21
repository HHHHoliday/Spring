package com.holidayX.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RestFulController {

    //原来的   :  http://localhost:8080/add?a=1&b=2
    //RestFul :  http://localhost:8080/add/1/2

    //映射访问路径
    @GetMapping("/commit/{p1}/{p2}")
    public String test1(@PathVariable int p1, @PathVariable int p2, Model model) {

        int result = p1 + p2;
        //Spring MVC会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg", "结果1：" + result);
        //返回视图位置
        return "test";
    }

    @PostMapping("/commit/{p1}/{p2}")
    public String test2(@PathVariable int p1, @PathVariable int p2, Model model) {

        int result = p1 + p2;
        //Spring MVC会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg", "结果2：" + result);
        //返回视图位置
        return "test";
    }
}
