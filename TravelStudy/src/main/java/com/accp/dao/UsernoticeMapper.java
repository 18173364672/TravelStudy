package com.accp.dao;

import com.accp.domain.Usernotice;
import com.accp.domain.UsernoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
 
public interface UsernoticeMapper {
    int countByExample(UsernoticeExample example);

    int deleteByExample(UsernoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usernotice record);

    int insertSelective(Usernotice record);

    List<Usernotice> selectByExample(UsernoticeExample example);

    Usernotice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Usernotice record, @Param("example") UsernoticeExample example);

    int updateByExample(@Param("record") Usernotice record, @Param("example") UsernoticeExample example);

    int updateByPrimaryKeySelective(Usernotice record);

    int updateByPrimaryKey(Usernotice record);
}