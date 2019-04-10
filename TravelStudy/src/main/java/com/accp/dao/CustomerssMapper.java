package com.accp.dao;

import com.accp.domain.Customerss;
import com.accp.domain.CustomerssExample;


import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerssMapper {
    int countByExample(CustomerssExample example);

    int deleteByExample(CustomerssExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Customerss record);

    int insertSelective(Customerss record);

    List<Customerss> selectByExample(CustomerssExample example);

    Customerss selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Customerss record, @Param("example") CustomerssExample example);

    int updateByExample(@Param("record") Customerss record, @Param("example") CustomerssExample example);

    int updateByPrimaryKeySelective(Customerss record);

    int updateByPrimaryKey(Customerss record);
    
    Customerss dl(@Param("Username")String Username,@Param("UserPassWord")String UserPassWord);
}