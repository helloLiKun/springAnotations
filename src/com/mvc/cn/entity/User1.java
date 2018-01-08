package com.mvc.cn.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Created by liKun on 2018/1/8 0008.
 */
@Component
public class User1 {
    User user;

    public User1() {
    }

    @Autowired
    public User1(@Qualifier("user")User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "User1{" +
                "user=" + user +
                '}';
    }
}
