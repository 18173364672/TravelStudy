package com.accp.hmf.service;


import java.util.List;

import com.accp.domain.Employee;
import com.accp.domain.Project;
import com.accp.domain.Projectimg;
import com.github.pagehelper.PageInfo;

public interface ProjectService {
   
	
	 public PageInfo<Project> querypage(Integer currentPage,Integer pageSize,String projectname);

	 int insertSelective(Project record);
	 
	 int insertSelective(Projectimg record);
	 
	 List<Projectimg> queryimg(Integer id);
	 
	
}
