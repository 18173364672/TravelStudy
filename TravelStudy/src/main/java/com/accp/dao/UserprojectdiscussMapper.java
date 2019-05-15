package com.accp.dao;

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
    
    List<Userprojectdiscuss>userproselecid(Integer id);
    
    //评论数
    int querycounthmf(Integer id);
    
    //好评数量
    int queryhphmf(Integer id);
    
    //差评数量
    int querycphmf(Integer id);
    
    //查询评论
    List<Userprojectdiscuss> queryplhmf(Integer id);
}