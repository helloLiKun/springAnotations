package test;

import com.mvc.cn.dao.SysUserDao;
import com.mvc.cn.dao.jdbcTemplate.JdbcDaoSupportSysUserDao;
import com.mvc.cn.dao.jdbcTemplate.JdbcTemplateSysUserDao;
import com.mvc.cn.entity.SysUser;
import com.mvc.cn.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by liKun on 2018/1/3 0003.
 */
public class TestUser {
    JdbcTemplateSysUserDao sysUserDao;

    JdbcDaoSupportSysUserDao jdbcDaoSupportSysUserDao;

    @Before
    public void initFile(){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("resource/applicationContext.xml");
        sysUserDao=ctx.getBean("jdbcTemplateSysUserDao",JdbcTemplateSysUserDao.class);
    }

    @Test
    public void findAll(){
//        List<SysUser> list=sysUserDao.findAll();
        List<SysUser> list=jdbcDaoSupportSysUserDao.findAll();
        System.out.println(list.size()+"-----------");
    }

    @Test
    public void addUser(){
        SysUser user=new SysUser();
        user.setIdNum("333");
        user.setName("zhangsan");
        user.setPwd("123");
        user.setId("1");
        user.setPhoneNum("123");
//        userService.addUser(user);
    }


}