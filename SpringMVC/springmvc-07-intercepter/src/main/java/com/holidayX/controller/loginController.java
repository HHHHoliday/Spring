package com.holidayX.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class loginController {

    //跳转到登录页面
    @RequestMapping("/gologin")
    public String gologin(){
        return "login";//跳转到login
    }

    //登录成功后跳转到main首页
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){
        //把用户信息存在session中：
        session.setAttribute("userLoginInfo",username);
        model.addAttribute("username",username);
        return "main";//跳转到main
    }

    @RequestMapping("/main")
    public String main(){
        return "main";//跳转到main
    }

    @RequestMapping("/goOut")
    public String login(HttpSession session){
        session.removeAttribute("userLoginInfo");
        return "login";//跳转到main
    }
}
