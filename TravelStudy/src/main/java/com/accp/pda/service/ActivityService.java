package com.accp.pda.service;

import java.util.List;

import com.accp.domain.Activity;
import com.accp.domain.ActivityExample;
import com.accp.domain.Project;

public interface ActivityService {
	
    List<Activity> selectByExample(ActivityExample example);
    
    Activity selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKey(Activity record);
    
    int deleteByPrimaryKey(Integer id);
    
    List<Activity> selectByName(String name);
    
    List<Project> selectPorject();

}
