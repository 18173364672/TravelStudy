package com.accp.hx.service;

import java.util.List;

import com.accp.domain.Project;
import com.accp.domain.ProjectExample;

public interface ProjectService1 {

	List<Project> selectByExample(ProjectExample example);
	
	  List<Project>proxmselect();
	  
	  Project proselectid(Integer id);
	  List<Project>proquery();
	
}
 