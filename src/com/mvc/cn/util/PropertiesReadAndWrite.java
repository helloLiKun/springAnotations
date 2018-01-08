package com.mvc.cn.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by liKun on 2018/1/8 0008.
 */
public class PropertiesReadAndWrite {
    //basePath获取系统的根路径(不能用编译后文件的路径this.getClass().getClassLoader().getResource("").getPath()取出编译后classes路径)
    String basePath = System.getProperty("user.dir");
    String sourcePath = basePath + "\\src\\resource\\jdbc.properties";
    String targetPath = basePath + "\\src\\resource\\jdbcCopy.properties";
    LinkedHashMap<String, String> map = new LinkedHashMap<>();

    public PropertiesReadAndWrite() {
    }

    //使用Properties从*.properties文件中读取key-value到java程序中
    public void readProperties() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(sourcePath));
            Enumeration enumeration = properties.propertyNames();
            while (enumeration.hasMoreElements()) {
                String key = (String) enumeration.nextElement();
                String value = (String) properties.get(key);
                map.put(key, value);
                System.out.println(key + "------" + value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //将java中的key-value写出到*.properties文件中
    public void writeProperties() {
        Properties properties = new Properties();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            properties.setProperty(entry.getKey(), entry.getValue());
            try {
                properties.store(new FileOutputStream(targetPath),null);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
