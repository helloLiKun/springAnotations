package com.mvc.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

/**
 * Created by liKun on 2018/1/9 0009.
 */
@Controller
public class HelloController extends BaseController implements Serializable {

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello");
        Integer.valueOf("abc");
        return "hello";
    }

    @RequestMapping("/hi")
    public String hi() {
        System.out.println("hi");
        String name = "abc";
        name.charAt(9);
        return "hello";
    }
}
