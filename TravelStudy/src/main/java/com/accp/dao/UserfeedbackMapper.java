package com.accp.dao;

import com.accp.domain.Userfeedback;
import com.accp.domain.UserfeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserfeedbackMapper {
    int countByExample(UserfeedbackExample example);

    int deleteByExample(UserfeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Userfeedback record);

    int insertSelective(Userfeedback record);

    List<Userfeedback> selectByExample(UserfeedbackExample example);

    Userfeedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Userfeedback record, @Param("example") UserfeedbackExample example);

    int updateByExample(@Param("record") Userfeedback record, @Param("example") UserfeedbackExample example);

    int updateByPrimaryKeySelective(Userfeedback record);

    int updateByPrimaryKey(Userfeedback record);
}