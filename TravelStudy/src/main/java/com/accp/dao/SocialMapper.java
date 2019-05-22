package com.accp.dao;

import com.accp.domain.Social;
import com.accp.domain.SocialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
 
public interface SocialMapper {
    int countByExample(SocialExample example);

    int deleteByExample(SocialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Social record);

    int insertSelective(Social record);

    List<Social> selectByExample(SocialExample example);
    
    List<Social>sidselect(@Param("uid")Integer uid);

    Social selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Social record, @Param("example") SocialExample example);

    int updateByExample(@Param("record") Social record, @Param("example") SocialExample example);

    int updateByPrimaryKeySelective(Social record);

    int updateByPrimaryKey(Social record);
}