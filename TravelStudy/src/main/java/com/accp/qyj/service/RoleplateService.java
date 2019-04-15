package com.accp.qyj.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Roleplate;
import com.accp.domain.RoleplateExample;

public interface RoleplateService {
	int countByExample(RoleplateExample example);

    int deleteByExample(RoleplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Roleplate record);

    int insertSelective(Roleplate record);

    List<Roleplate> selectByExample(RoleplateExample example);

    Roleplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Roleplate record, @Param("example") RoleplateExample example);

    int updateByExample(@Param("record") Roleplate record, @Param("example") RoleplateExample example);

    int updateByPrimaryKeySelective(Roleplate record);

    int updateByPrimaryKey(Roleplate record);    
    
    List<Roleplate> querybyid(@Param("rid") Integer rid);
    
    int deleteByRid(@Param("rid") Integer rid);
}
