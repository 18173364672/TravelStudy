package com.accp.dao;

import com.accp.domain.Projectimg;
import com.accp.domain.ProjectimgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectimgMapper {
    int countByExample(ProjectimgExample example);

    int deleteByExample(ProjectimgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Projectimg record);

    int insertSelective(Projectimg record);

    List<Projectimg> selectByExample(ProjectimgExample example);

    Projectimg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Projectimg record, @Param("example") ProjectimgExample example);

    int updateByExample(@Param("record") Projectimg record, @Param("example") ProjectimgExample example);

    int updateByPrimaryKeySelective(Projectimg record);

    int updateByPrimaryKey(Projectimg record);
    
    List<Projectimg>proimgselect(Integer id);
}