package com.accp.hx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.CustomerssMapper;
import com.accp.dao.ProjectMapper;
import com.accp.dao.UserprojectdiscussMapper;
import com.accp.domain.Customerss;
import com.accp.domain.Project;
import com.accp.domain.ProjectExample;
import com.accp.domain.Userprojectdiscuss;
import com.accp.hx.service.ProjectService1;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class ProjectServiceImpl1 implements ProjectService1{

	@Autowired
	ProjectMapper ProjectMapper;
	@Autowired
	UserprojectdiscussMapper um;
	@Autowired
	CustomerssMapper cm;
	
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

	@Override
	public int querycounthmf(Integer id) {
		// TODO Auto-generated method stub
		return um.querycounthmf(id);
	}

	@Override
	public int queryhphmf(Integer id) {
		// TODO Auto-generated method stub
		return um.queryhphmf(id);
	}

	@Override
	public int querycphmf(Integer id) {
		// TODO Auto-generated method stub
		return um.querycphmf(id);
	}

	@Override
	public List<Userprojectdiscuss> queryplhmf(Integer id) {
		// TODO Auto-generated method stub
		return um.queryplhmf(id);
	}

	@Override
	public PageInfo<Userprojectdiscuss> querypage(Integer currentPage, Integer pageSize,Integer id) {
		// TODO Auto-generated method stub
		Page<Userprojectdiscuss> p = PageHelper.startPage(currentPage, pageSize,true);
		List<Userprojectdiscuss> list=um.queryplhmf(id);
		for (Userprojectdiscuss userprojectdiscuss : list) {
			Customerss c=cm.cuqueryd(userprojectdiscuss.getUserid());
			userprojectdiscuss.setUname(c.getUsername());
		}
		return p.toPageInfo();
	}

}
