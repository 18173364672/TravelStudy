package com.accp.hmf.service;

import java.util.List;

import com.accp.domain.Employee;
import com.accp.domain.Organization;
import com.accp.domain.Organizationzw;
import com.github.pagehelper.PageInfo;

public interface OrganizationService {
     
	  //删除部门
	 int deleteByPrimaryKey(Integer id);
	
	 //更新部门
	 int updateByPrimaryKeySelective(Organization record);
	
	 //查询部门名称
	public Organization queryOrname(Integer id);
	
	//插入部门
	int insertSelective(Organization record); 
	
	//部门信息查询
	 public PageInfo<Organization> querypage(Integer currentPage,Integer pageSize,String name);
	
	 //查询在职员工
	 List<Employee> emquerybm(Integer id);
	 
	 //添加职位
	 public int insertSelective(Organizationzw organizationzw);
	 
	 //查询职位
	 List<Organizationzw> queryzw(Integer id);
	 
	 //删除职位
	 int deletezw(Integer id);
}
