package com.accp.hx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Customerss;
import com.accp.domain.Project;
import com.accp.domain.ProjectExample;
import com.accp.hx.service.CustomerssService;
import com.accp.hx.service.ProjectService;
import com.alibaba.fastjson.JSON;

//@Controller
//@RestController
//@RequestMapping("/projectcontroller") 
public class ProjectController {

	
	@Autowired
	ProjectService ProjectService;
	
	@RequestMapping("/projectselect")
	public String projectselect(ProjectExample example) {
		List<Project> list=ProjectService.selectByExample(null);
		String o=JSON.toJSONString(list);
		System.out.println(o);
		return o;
	}
	
	@RequestMapping("/proxmselect")
	public String proxmselect() {
		List<Project> list=ProjectService.proxmselect();
		String o=JSON.toJSONString(list);
		System.out.println(o);
		return o;
	}
}
