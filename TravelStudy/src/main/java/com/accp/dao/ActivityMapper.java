package com.accp.dao;

import com.accp.domain.Activity;
import com.accp.domain.ActivityExample;
import com.accp.domain.ActivityTwo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityMapper {
    int countByExample(ActivityExample example);

    int deleteByExample(ActivityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Activity record);

    int insertSelective(Activity record);

    List<Activity> selectByExample(ActivityExample example);

    Activity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
    
    List<ActivityTwo> selectByNameAndCount();
   
    List<Activity> selectByName(@Param("name") String name);
    
    Activity activitylbselect(Integer id);
}