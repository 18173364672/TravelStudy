package com.accp.dao;

import com.accp.domain.Customergroup;
import com.accp.domain.CustomergroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomergroupMapper {
    int countByExample(CustomergroupExample example);

    int deleteByExample(CustomergroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Customergroup record);

    int insertSelective(Customergroup record);

    List<Customergroup> selectByExample(CustomergroupExample example);

    Customergroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Customergroup record, @Param("example") CustomergroupExample example);

    int updateByExample(@Param("record") Customergroup record, @Param("example") CustomergroupExample example);

    int updateByPrimaryKeySelective(Customergroup record);

    int updateByPrimaryKey(Customergroup record);
}