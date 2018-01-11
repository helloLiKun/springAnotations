package test;

import com.mvc.cn.dao.jdbcTemplate.JdbcDaoSupportSysUserDao;
import com.mvc.cn.dao.jdbcTemplate.JdbcTemplateSysUserDao;
import com.mvc.cn.entity.SysUser;
import com.mvc.cn.entity.SysUserExample;
import com.mvc.cn.mapper.SysUserMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by liKun on 2018/1/3 0003.
 */
public class TestUser {
    ApplicationContext ctx=null;

    JdbcTemplateSysUserDao sysUserDao;

    JdbcDaoSupportSysUserDao jdbcDaoSupportSysUserDao;

    SysUserMapper sysUserMapper;

    @Before
    public void initFile(){
        ctx = new ClassPathXmlApplicationContext("resource/applicationContext.xml");
        sysUserDao=ctx.getBean("jdbcTemplateSysUserDao",JdbcTemplateSysUserDao.class);
        jdbcDaoSupportSysUserDao=ctx.getBean("jdbcDaoSupportSysUserDao",JdbcDaoSupportSysUserDao.class);
        sysUserMapper=ctx.getBean("sysUserMapper",SysUserMapper.class);
    }

    @Test
    public void findAll(){
        List<SysUser> list=sysUserDao.findAll();
//        List<SysUser> list=jdbcDaoSupportSysUserDao.findAll();
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

    @Test
    public void testUser(){
        SysUserExample sysUserExample=new SysUserExample();
        List<SysUser> list=sysUserMapper.selectByExample(sysUserExample);
        System.out.println("------------"+list.size());
    }


}