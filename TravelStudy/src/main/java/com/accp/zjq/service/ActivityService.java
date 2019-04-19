package com.accp.zjq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.dao.ActivityMapper;
import com.accp.domain.ActivityTwo;

@Service
public class ActivityService {
	
	@Autowired
	ActivityMapper am;
	
	public List<ActivityTwo> selectByNameAndCount(){
		return am.selectByNameAndCount();
	} 
}
