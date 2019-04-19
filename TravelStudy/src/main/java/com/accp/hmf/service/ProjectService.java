package com.accp.hmf.service;


import com.accp.domain.Project;
import com.github.pagehelper.PageInfo;

public interface ProjectService {
   
	
	 public PageInfo<Project> querypage(Integer currentPage,Integer pageSize,String projectname);

	 int insertSelective(Project record);
}
