package com.mvc.cn.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liKun on 2018/1/9 0009.
 * 异常处理常用方法一：
 * 使用@ExceptionHandler进行异常处理，但必须遵循以下2点
 * 1、需要被处理的Controller类必须继承BaseController
 * 2、被@ExcptionHandler标注的方法中只能用HttpServletRequest/HttpServletResponse而不能用ServletRequest/ServletResponse
 * (两者区别是前者遵循http协议，前者为后者子类)
 * 异常处理常用方法二：
 * 详见dispatcher-servlet.xml配置SimpleMappingExceptionResolver
 *
 */
public abstract class BaseController {
    @ExceptionHandler
    public String handleException(Exception e,
                                  HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        if(e instanceof NumberFormatException) {
            request.setAttribute("message", "亲,请输入数字哦.");
            return "error";
        } else {
            throw e;
        }
    }
}

