package com.holidayX.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.holidayX.pojo.User;
import com.holidayX.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
//@Controller
public class UserController {

    @RequestMapping(value = "/json1")
    //@ResponseBody//不会走视图解析器,直接返回一个字符串
    public String json1() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User("橙汁1",80,"女");
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(user);
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return str;
    }

    @RequestMapping("/json2")
    public String json2() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个集合
        List<User> userList = new ArrayList<User>();
        User user1 = new User("橙汁1",80,"女");
        User user2 = new User("橙汁2",80,"女");
        User user3 = new User("橙汁3",80,"女");
        User user4 = new User("橙汁4",80,"女");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(userList);
        return str;
    }

    @RequestMapping("/json3")
    public String json3() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个时间对象
        Date date = new Date();
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return mapper.writeValueAsString(sdf.format(date));
    }

    @RequestMapping("/json4")
    public String json4() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定日期格式
        mapper.setDateFormat(sdf);

        Date date = new Date();
        String str = mapper.writeValueAsString(date);
        return str;
    }

    //利用工具类Utils实现json2的简化
    @RequestMapping(value = "/json5")
    public String json5() throws JsonProcessingException {

        List<User> userList = new ArrayList<User>();
        User user1 = new User("橙汁1",80,"女");
        User user2 = new User("橙汁2",80,"女");
        User user3 = new User("橙汁3",80,"女");
        User user4 = new User("橙汁4",80,"女");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        return JsonUtils.getJson(userList);
    }

    //利用工具类Utils实现json4的简化
    @RequestMapping("/json6")
    public String json6() throws JsonProcessingException {
        Date date = new Date();
        return JsonUtils.getJson(date);
    }

    //利用工具类Utils实现json4的简化
    @RequestMapping("/json7")
    public String json7(){
        //创建一个对象
        User user1 = new User("橙汁1",80,"女");
        User user2 = new User("橙汁2",80,"女");
        User user3 = new User("橙汁3",80,"女");
        User user4 = new User("橙汁4",80,"女");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);
        return "Hello";
    }
}
