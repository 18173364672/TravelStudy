package com.accp.dao;

import com.accp.domain.Thumbup;
import com.accp.domain.ThumbupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThumbupMapper {
    int countByExample(ThumbupExample example);

    int deleteByExample(ThumbupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Thumbup record);

    int insertSelective(Thumbup record);

    List<Thumbup> selectByExample(ThumbupExample example);

    Thumbup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Thumbup record, @Param("example") ThumbupExample example);

    int updateByExample(@Param("record") Thumbup record, @Param("example") ThumbupExample example);

    int updateByPrimaryKeySelective(Thumbup record);

    int updateByPrimaryKey(Thumbup record);
}