package com.accp.qyj.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Role;
import com.accp.domain.RoleExample;
import com.github.pagehelper.PageInfo;

public interface RoleService {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> queryAll(@Param("name")String name);
    
    int deleteAll(Integer[] rid);
    
    public PageInfo<Role> queryByPage(Integer currentPage , Integer pageSize , String name);
}
