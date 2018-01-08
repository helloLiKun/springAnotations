package test;

import com.mvc.cn.entity.Company;
import com.mvc.cn.entity.JDBC;
import com.mvc.cn.entity.User;
import com.mvc.cn.util.PropertiesReadAndWrite;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by liKun on 2018/1/3 0003.
 */
public class TestUser {
    AbstractApplicationContext ac;
    @Before
    public void initSpring(){
        String cfg="resource/applicationContext.xml";
        ac =new ClassPathXmlApplicationContext(cfg);
        System.out.println("----------reload----------");
    }

    @Test
    public void testConstructorAndSetter(){
        System.out.println("-----constructor-----");
        User user=ac.getBean("user",User.class);
        System.out.println("---user---"+user);
    }

    @Test
    public void testAutowired(){
        System.out.println("----------begin---------------");
        User user=ac.getBean("user_byType",User.class);
        User user1=ac.getBean("user_byType",User.class);
        System.out.println("--------:"+(user==user1));
    }

    @Test
    public void testRef(){
        Company company=ac.getBean("company",Company.class);
        System.out.println(company);
    }

    @Test
    public void testProperties(){
        PropertiesReadAndWrite propertiesReadAndWrite=(PropertiesReadAndWrite) ac.getBean("propertiesReadAndWrite");
        propertiesReadAndWrite.readProperties();
        propertiesReadAndWrite.writeProperties();
    }

    @Test
    public void jdbc(){
        JDBC jdbc=ac.getBean("jdbc", JDBC.class);
        System.out.println(jdbc);
    }

    @Test
    public void testMap(){
        Map<String,String> map=ac.getBean("testMap", Map.class);
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+"-----"+entry.getValue());
        }
    }
}