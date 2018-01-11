package com.mvc.cn.dao;

import com.mvc.cn.entity.SysUser;

import java.util.List;

/**
 * Created by liKun on 2018/1/10 0010.
 */
public interface SysUserDao {
    List<SysUser> findAll();
    SysUser findById(String id);
    void save(SysUser emp);
    void update(SysUser emp);
    void delete(String id);
}
