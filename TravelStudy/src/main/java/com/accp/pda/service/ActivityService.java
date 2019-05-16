package com.accp.pda.service;

import java.util.List;

import com.accp.domain.Activity;
import com.accp.domain.ActivityExample;
import com.accp.domain.Project;
import com.accp.pda.vo.ActivtyVo;

public interface ActivityService {
	
    List<Activity> selectByExample(ActivityExample example);
    
    Activity selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKey(Activity record);
    
    int deleteByPrimaryKey(Integer id);
    
    List<Activity> selectByName(String name);
    
    List<Project> selectPorject();

    ActivtyVo acvo(Integer id);
    
    int insertSelective(Activity record);
    int insertevtime(Activity ac);
    
    List<Activity> query(String name);
}
