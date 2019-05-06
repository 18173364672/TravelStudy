package com.accp.qyj.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Userrole;
import com.accp.domain.UserroleExample;

public interface UserroleService {
	int countByExample(UserroleExample example);

    int deleteByExample(UserroleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Userrole record);

    int insertSelective(Userrole record);

    List<Userrole> selectByExample(UserroleExample example);

    Userrole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Userrole record, @Param("example") UserroleExample example);

    int updateByExample(@Param("record") Userrole record, @Param("example") UserroleExample example);

    int updateByPrimaryKeySelective(Userrole record);

    int updateByPrimaryKey(Userrole record);
    
    int delete(@Param("id")Integer id);
}
