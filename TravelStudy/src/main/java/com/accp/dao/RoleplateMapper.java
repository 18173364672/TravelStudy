package com.accp.dao;

import com.accp.domain.Roleplate;
import com.accp.domain.RoleplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
 
public interface RoleplateMapper {
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
}