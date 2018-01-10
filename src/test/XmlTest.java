package test;

import com.mvc.cn.entity.Company;
import com.mvc.cn.entity.User;
import com.mvc.cn.entity.User1;
import com.mvc.cn.util.PropertiesReadAndWrite;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by liKun on 2018/1/10 0010.
 */
public class XmlTest {
    AbstractApplicationContext ac;
    @Before
    public void initSpring(){
        String cfg="resource/applicationContext.xml";
        ac =new ClassPathXmlApplicationContext(cfg);
        System.out.println("----------reload----------");
    }

    @Test
    public void testMap(){
        Map<String,String> map=ac.getBean("testMap", Map.class);
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+"-----"+entry.getValue());
        }
    }

    @Test
    public void testUser(){
        User user1=ac.getBean("user",User.class);
        User user2=ac.getBean("user",User.class);
        System.out.println("user1==2:"+(user1==user2));
        ac.close();
    }

    @Test
    public void testCompany(){
        Company company=ac.getBean("company",Company.class);
        System.out.println("company:"+company);
    }

    @Test
    public void testUser1(){
        User1 user1=ac.getBean("user1",User1.class);
        System.out.println(user1);
    }

    @Test
    public void testProperties(){
        PropertiesReadAndWrite propertiesReadAndWrite=(PropertiesReadAndWrite) ac.getBean("propertiesReadAndWrite");
        propertiesReadAndWrite.readProperties();
        propertiesReadAndWrite.writeProperties();
    }
}
