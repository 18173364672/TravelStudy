package com.accp.dao;
 
import com.accp.domain.Wages;
import com.accp.domain.WagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WagesMapper {
    int countByExample(WagesExample example);

    int deleteByExample(WagesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Wages record);

    int insertSelective(Wages record);

    List<Wages> selectByExample(WagesExample example);

    Wages selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Wages record, @Param("example") WagesExample example);

    int updateByExample(@Param("record") Wages record, @Param("example") WagesExample example);

    int updateByPrimaryKeySelective(Wages record);

    int updateByPrimaryKey(Wages record);
}