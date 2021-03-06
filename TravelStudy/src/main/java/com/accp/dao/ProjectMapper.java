package com.accp.dao;

import com.accp.domain.Project;
import com.accp.domain.ProjectByTimeAndName;
import com.accp.domain.ProjectExample;
import com.accp.domain.QuestionTj;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMapper {
    int countByExample(ProjectExample example);

    int deleteByExample(ProjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    List<Project> selectByExample(ProjectExample example);

    Project selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
    
    List<ProjectByTimeAndName> superSelectBytime(String years);
    
    List<QuestionTj>selectByQuestionTj(String projectname);
    
    List<Project> pquery(@Param("projectname") String projectname);
    
    List<Project> queryByActId(@Param("id") Integer id);
    
    List<Project> selectPorject();
    
    Project queryd(Integer id);
    
    List<Project>proselect(Integer pid);
    
    List<Project>proxmselect();
    
    List<ProjectByTimeAndName> selectXmTable(@Param("years") String years,@Param("projectname") String name);
    
    List<Project> queryByaid(@Param("id")Integer id);
    
}