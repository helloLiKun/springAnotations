package com.mvc.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liKun on 2017/12/29 0029.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String printHello() {
        System.out.println("--------hello controller----------");
//        model.addAttribute("msg", "Spring MVC Hello World");
//        model.addAttribute("name", "yuntao");
        return "hello";
    }
}
