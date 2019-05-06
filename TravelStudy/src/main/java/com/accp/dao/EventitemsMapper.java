package com.accp.dao;

import com.accp.domain.Eventitems;
import com.accp.domain.EventitemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventitemsMapper {
    int countByExample(EventitemsExample example);

    int deleteByExample(EventitemsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Eventitems record);

    int insertSelective(Eventitems record);

    List<Eventitems> selectByExample(EventitemsExample example);

    Eventitems selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Eventitems record, @Param("example") EventitemsExample example);

    int updateByExample(@Param("record") Eventitems record, @Param("example") EventitemsExample example);

    int updateByPrimaryKeySelective(Eventitems record);

    int updateByPrimaryKey(Eventitems record);
    
    List<Eventitems>eveselect(Integer id);
}