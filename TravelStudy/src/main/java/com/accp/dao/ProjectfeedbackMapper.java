package com.accp.dao;

import com.accp.domain.Projectfeedback;
import com.accp.domain.ProjectfeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectfeedbackMapper {
    int countByExample(ProjectfeedbackExample example);

    int deleteByExample(ProjectfeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Projectfeedback record);

    int insertSelective(Projectfeedback record);

    List<Projectfeedback> selectByExample(ProjectfeedbackExample example);

    Projectfeedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Projectfeedback record, @Param("example") ProjectfeedbackExample example);

    int updateByExample(@Param("record") Projectfeedback record, @Param("example") ProjectfeedbackExample example);

    int updateByPrimaryKeySelective(Projectfeedback record);

    int updateByPrimaryKey(Projectfeedback record);
}