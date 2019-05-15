package com.accp.hx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.dao.ActivityMapper;
import com.accp.domain.Activity;
import com.accp.domain.ActivityExample;
import com.accp.domain.Post;
import com.accp.hx.service.ActivityService1;
import com.alibaba.fastjson.JSON;

@Controller
@RestController
@RequestMapping("/ActivityController") 
public class ActivsityController1 {

	@Autowired
	ActivityService1 ActivityService1;
	
	@RequestMapping("/Activityselect")
	public String Activityselect(ActivityExample example) {
		List<Activity> list=ActivityService1.selectByExample(null);
		String o=JSON.toJSONString(list);
		System.out.println(o);
		return o;
	}
 
	      
	@RequestMapping("/activitylbselect")
	public Activity activitylbselect(Integer id) {
		Activity list=ActivityService1.activitylbselect(id);
		String o=JSON.toJSONString(list);
		System.out.println(o);
		return list;
	}
}
