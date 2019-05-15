package com.accp.hx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.dao.ActivityMapper;
import com.accp.domain.Activity;
import com.accp.domain.ActivityExample;
import com.accp.hx.service.ActivityService1;

@Service
public class ActivityServiceImpl1 implements ActivityService1{

	@Autowired
	ActivityMapper ActivsityMapper;
	
	@Override
	public List<Activity> selectByExample(ActivityExample example) {
		// TODO Auto-generated method stub
		return ActivsityMapper.selectByExample(example);
	}

	@Override
	public Activity activitylbselect(Integer id) {
		// TODO Auto-generated method stub
		return ActivsityMapper.activitylbselect(id);
	}

}
