package com.holidayX.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //放行：判断什么情况下登录
        //1.已经是登录状态，即session已经有内容
        if(session.getAttribute("userLoginInfo")!=null){
            return true;
        }
        //2.正在登录页面
        if(request.getRequestURI().contains("gologin") || request.getRequestURI().contains("login")){
            return true;
        }

        //其他情况就拦截，跳转到登录页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
