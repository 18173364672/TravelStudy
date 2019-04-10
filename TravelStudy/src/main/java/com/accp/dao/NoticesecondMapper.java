package com.accp.dao;

import com.accp.domain.Noticesecond;
import com.accp.domain.NoticesecondExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticesecondMapper {
    int countByExample(NoticesecondExample example);

    int deleteByExample(NoticesecondExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Noticesecond record);

    int insertSelective(Noticesecond record);

    List<Noticesecond> selectByExample(NoticesecondExample example);

    Noticesecond selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Noticesecond record, @Param("example") NoticesecondExample example);

    int updateByExample(@Param("record") Noticesecond record, @Param("example") NoticesecondExample example);

    int updateByPrimaryKeySelective(Noticesecond record);

    int updateByPrimaryKey(Noticesecond record);
}