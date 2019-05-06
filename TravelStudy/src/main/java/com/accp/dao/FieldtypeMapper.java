package com.accp.dao;

import com.accp.domain.Field;
import com.accp.domain.Fieldtype;
import com.accp.domain.FieldtypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FieldtypeMapper {
    int countByExample(FieldtypeExample example);

    int deleteByExample(FieldtypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Fieldtype record);

    int insertSelective(Fieldtype record);

    List<Fieldtype> selectByExample(FieldtypeExample example);

    Fieldtype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Fieldtype record, @Param("example") FieldtypeExample example);

    int updateByExample(@Param("record") Fieldtype record, @Param("example") FieldtypeExample example);

    int updateByPrimaryKeySelective(Fieldtype record);

    int updateByPrimaryKey(Fieldtype record);
    
    Fieldtype queryfname(Integer id);
    
    
}