package com.accp.hx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.ProjectMapper;
import com.accp.domain.Project;
import com.accp.domain.ProjectExample;
import com.accp.hx.service.ProjectService;

//@Service
//@Transactional
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectMapper ProjectMapper;
	
	@Override
	public List<Project> selectByExample(ProjectExample example) {
		// TODO Auto-generated method stub
		return ProjectMapper.selectByExample(example);
	}

	@Override
	public List<Project> proxmselect() {
		// TODO Auto-generated method stub
		return ProjectMapper.proxmselect();
	}

}
