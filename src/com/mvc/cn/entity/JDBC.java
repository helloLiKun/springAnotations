package com.mvc.cn.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by liKun on 2018/1/8 0008.
 */
@Component("jdbc")
public class JDBC {
    @Value("#{prop.ip}")
    String ip;
    @Value("#{prop.name}")
    String username;
    @Value("#{prop.password}")
    String password;
    @Value("#{prop.identify}")
    String identify;
    @Value("#{prop.max_connect}")
    String maxConnect;

    public JDBC() {
    }

    public JDBC(String ip, String username, String password, String identify, String maxConnect) {
        this.ip = ip;
        this.username = username;
        this.password = password;
        this.identify = identify;
        this.maxConnect = maxConnect;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getMaxConnect() {
        return maxConnect;
    }

    public void setMaxConnect(String maxConnect) {
        this.maxConnect = maxConnect;
    }

    @Override
    public String toString() {
        return "JDBC{" +
                "ip='" + ip + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", identify='" + identify + '\'' +
                ", maxConnect='" + maxConnect + '\'' +
                '}';
    }
}
