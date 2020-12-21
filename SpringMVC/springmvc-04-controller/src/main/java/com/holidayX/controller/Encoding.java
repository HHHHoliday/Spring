package com.holidayX.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Encoding {
    @RequestMapping("/e/t")
    public String test(Model model, String name){
        model.addAttribute("msg",name); //获取表单提交的值
        System.out.println(name);
        return "test"; //跳转到test页面显示输入的值
    }
}
