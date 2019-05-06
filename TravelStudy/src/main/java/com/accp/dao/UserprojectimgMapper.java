package com.accp.dao;

import com.accp.domain.Userprojectimg;
import com.accp.domain.UserprojectimgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserprojectimgMapper {
    int countByExample(UserprojectimgExample example);

    int deleteByExample(UserprojectimgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Userprojectimg record);

    int insertSelective(Userprojectimg record);

    List<Userprojectimg> selectByExample(UserprojectimgExample example);

    Userprojectimg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Userprojectimg record, @Param("example") UserprojectimgExample example);

    int updateByExample(@Param("record") Userprojectimg record, @Param("example") UserprojectimgExample example);

    int updateByPrimaryKeySelective(Userprojectimg record);

    int updateByPrimaryKey(Userprojectimg record);
    
    List<Userprojectimg>userproimgselecid(Integer id);
}