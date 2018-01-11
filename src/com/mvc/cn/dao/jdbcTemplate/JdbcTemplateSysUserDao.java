package com.mvc.cn.dao.jdbcTemplate;

import com.mvc.cn.dao.SysUserDao;
import com.mvc.cn.entity.SysUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by liKun on 2018/1/10 0010.
 */
@Repository
public class JdbcTemplateSysUserDao implements SysUserDao {
    //spring 整合jdbc方式一：注入jdbcTemplate
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<SysUser> findAll() {
        String sql = "select * from SYS_USER";
        return jdbcTemplate.query(sql,new EmpRowMapper());
    }
    @Override
    public SysUser findById(String id) {
        String sql = "select * from SYS_USER where IDENTITY =?";
        return jdbcTemplate.queryForObject(
                sql, new Object[]{id}, new EmpRowMapper());
    }

    @Override
    public void save(SysUser emp) {
        String sql = "insert into SYS_USER values(?,?,?,?,?)";
        Object[] params = { emp.getId(),emp.getName(),emp.getIdNum(),
                emp.getPwd(),emp.getPhoneNum()
        };
        jdbcTemplate.update(sql, params);
    }
    @Override
    public void update(SysUser emp) {
        String sql = "update SYS_USER set " +
                "name=?,id=?,idNum=?,phoneNum=?," +
                "pwd=? " +
                "where id=?";
        Object[] params = {emp.getName(), emp.getId(),
                emp.getIdNum(), emp.getPhoneNum(),
                emp.getPwd()};
        jdbcTemplate.update(sql, params);
    }
    @Override
    public void delete(String id) {
        String sql = "delete from SYS_USER where id=?";
        jdbcTemplate.update(sql, id);
    }

    class EmpRowMapper implements RowMapper<SysUser> {
        @Override
        public SysUser mapRow(ResultSet resultSet, int i) throws SQLException {
            SysUser user=new SysUser();
            user.setName(resultSet.getString("name"));
            user.setId(resultSet.getString("id"));
            user.setPwd(resultSet.getString("pwd"));
            user.setPhoneNum(resultSet.getString("phone_num"));
            user.setIdNum(resultSet.getString("id_num"));
            return user;
        }
    }
}
