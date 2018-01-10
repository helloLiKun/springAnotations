package com.mvc.cn.dao.jdbcTemplate;

import com.mvc.cn.dao.SysUserDao;
import com.mvc.cn.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by liKun on 2018/1/10 0010.
 */
@Repository
public class JdbcDaoSupportSysUserDao  extends JdbcDaoSupport implements SysUserDao{

    JdbcTemplate jdbcTemplate=this.getJdbcTemplate();

    @Override
    public List<SysUser> findAll() {
        String sql = "select * from SYS_USER";
        return jdbcTemplate.query(sql,new JdbcDaoSupportSysUserDao.EmpRowMapper());
    }
    @Override
    public SysUser findById(String id) {
        String sql = "select * from SYS_USER where IDENTITY =?";
        return this.getJdbcTemplate().queryForObject(
                sql, new Object[]{id}, new JdbcDaoSupportSysUserDao.EmpRowMapper());
    }

    @Override
    public void save(SysUser emp) {
        String sql = "insert into SYS_USER values(?,?,?,?,?)";
        Object[] params = { emp.getId(),emp.getName(),emp.getIdNum(),
                emp.getPwd(),emp.getPhoneNum()
        };
        this.getJdbcTemplate().update(sql, params);
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
        this.getJdbcTemplate().update(sql, params);
    }
    @Override
    public void delete(String id) {
        String sql = "delete from SYS_USER where id=?";
        this.getJdbcTemplate().update(sql, id);
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
