package com.accp.pda.service;

import java.util.List;

import com.accp.domain.Activity;
import com.accp.domain.ActivityExample;

public interface ActivityService {
	
    List<Activity> selectByExample(ActivityExample example);
    
}
