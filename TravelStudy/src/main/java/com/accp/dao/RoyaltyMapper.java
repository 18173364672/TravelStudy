package com.accp.dao;

import com.accp.domain.Royalty;
import com.accp.domain.RoyaltyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoyaltyMapper {
    int countByExample(RoyaltyExample example);

    int deleteByExample(RoyaltyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Royalty record);

    int insertSelective(Royalty record);

    List<Royalty> selectByExample(RoyaltyExample example);

    Royalty selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Royalty record, @Param("example") RoyaltyExample example);

    int updateByExample(@Param("record") Royalty record, @Param("example") RoyaltyExample example);

    int updateByPrimaryKeySelective(Royalty record);

    int updateByPrimaryKey(Royalty record);
    
    int queryemp(Integer id);
    
    List<Royalty> querypay(Integer id);
}