package com.accp.hmf.service;

import java.util.List;

import com.accp.domain.Employee;
import com.accp.domain.Organization;
import com.github.pagehelper.PageInfo;

public interface OrganizationService {
     
	  
	 int deleteByPrimaryKey(Integer id);
	
	 int updateByPrimaryKey(Organization record);
	
	public Organization queryOrname(Integer id);
	
	int insertSelective(Organization record); 
	
	 public PageInfo<Organization> querypage(Integer currentPage,Integer pageSize,String name);
	
	 List<Employee> emquerybm(Integer id);
}
