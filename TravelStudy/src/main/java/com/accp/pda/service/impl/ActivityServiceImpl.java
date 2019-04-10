package com.accp.pda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.ActivityMapper;
import com.accp.domain.Activity;
import com.accp.domain.ActivityExample;
import com.accp.pda.service.ActivityService;

@Transactional
@Service
public class ActivityServiceImpl implements ActivityService{

	@Autowired
	ActivityMapper mapper;
	
	@Override
	public List<Activity> selectByExample(ActivityExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}

}
