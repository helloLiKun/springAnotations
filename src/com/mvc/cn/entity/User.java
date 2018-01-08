package com.mvc.cn.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by liKun on 2018/1/8 0008.
 */
@Component
@Scope("singleton")
public class User {
    private String name;
    private int age;
    private String sex;
    private float height;
    private float weight;

    public User() {
        System.out.println("run null constructor");
    }

    public User(String name, int age, String sex, float height, float weight) {
        System.out.println("run args constructor");
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }

    @PostConstruct
    public void init_method(){
        System.out.println("初始化--------");
    }

    @PreDestroy
    public void destroy_method(){
        System.out.println("销毁--------");
    }

    public String getName() {
        System.out.println("run name-getter");
        return name;
    }

    public void setName(String name) {
        System.out.println("run name-setter");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
