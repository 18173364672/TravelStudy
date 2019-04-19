package com.accp.dao;

import com.accp.domain.MydAndName;
import com.accp.domain.Userprojectdiscuss;
import com.accp.domain.UserprojectdiscussExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserprojectdiscussMapper {
    int countByExample(UserprojectdiscussExample example);

    int deleteByExample(UserprojectdiscussExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Userprojectdiscuss record);

    int insertSelective(Userprojectdiscuss record);

    List<Userprojectdiscuss> selectByExample(UserprojectdiscussExample example);

    Userprojectdiscuss selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Userprojectdiscuss record, @Param("example") UserprojectdiscussExample example);

    int updateByExample(@Param("record") Userprojectdiscuss record, @Param("example") UserprojectdiscussExample example);

    int updateByPrimaryKeySelective(Userprojectdiscuss record);

    int updateByPrimaryKey(Userprojectdiscuss record);
    
    List<MydAndName> selectByMyd();
    
    List<MydAndName> selectByCp();
}