package com.holidayX.controller;

import com.holidayX.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;

@Controller
@RequestMapping("/user")
public class UserController {

    //localhost:8080/springmvc_04_controller_war_exploded/user/t1?name=xxx
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        //1.接受前端参数
        System.out.println("前端传来的参数为："+name);
        //2.将返回结果传递给前端
        model.addAttribute("msg",name);
        //3.视图跳转
        return "test";
    }

    //前端接受的是一个对象
    //如果使用对象的话，前端传递的参数名和对象名必须一致，否则参数值就是null。
    @GetMapping("/t2")
    public String test2(User user){
        System.out.println(user);
        return "test";
    }
}
