package com.mvc.cn.controller;

import com.mvc.cn.entity.SysUser;
import com.mvc.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

/**
 * Created by liKun on 2018/1/9 0009.
 */
@Controller
public class HelloController implements Serializable {

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request) {
        System.out.println("hello");
        request.setAttribute("message","出错了");
        Integer.valueOf("abc");
        return "hello";
    }



    @RequestMapping("/add")
    @ResponseBody
    public void addUser(){
        SysUser user=new SysUser();
        user.setName("zhangsan");
        user.setPwd("123");
        user.setId("1");
        user.setPhoneNum("123");
        System.out.println("---success------");
    }



}
