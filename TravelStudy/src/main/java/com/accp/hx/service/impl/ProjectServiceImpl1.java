package com.accp.hx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.ProjectMapper;
import com.accp.domain.Project;
import com.accp.domain.ProjectExample;
import com.accp.hx.service.ProjectService1;

@Service
@Transactional
public class ProjectServiceImpl1 implements ProjectService1{

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

	@Override
	public Project proselectid(Integer id) {
		// TODO Auto-generated method stub
		return ProjectMapper.proselectid(id);
	}

	@Override
	public List<Project> proquery() {
		// TODO Auto-generated method stub 
		return ProjectMapper.proquery();
	}

}
