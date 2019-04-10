package com.accp.zjq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.dao.ProjectMapper;
import com.accp.domain.Project;

@Service
public class ProjectService {

	@Autowired
	ProjectMapper pm;
	
	public List<Project> queryAllProject(){
		return pm.selectByExample(null);
	}
}
