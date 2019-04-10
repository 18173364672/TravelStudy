package com.accp.hmf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.EmployeeMapper;
import com.accp.dao.OrganizationMapper;
import com.accp.domain.Employee;
import com.accp.domain.Organization;
import com.accp.hmf.service.EmployeeService;
import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class EmployeeServiceimpl implements EmployeeService{
     
	@Autowired
	EmployeeMapper em;
	@Autowired
	OrganizationMapper om;
    
	
	
	
	




	@Override
	public PageInfo<Employee> querypage(Integer currentPage, Integer pageSize,String createtime,String employeename) {
		// TODO Auto-generated method stub
		Page<Employee> p = PageHelper.startPage(currentPage, pageSize,true);
	    List<Employee> list=em.empquery(createtime, employeename);
	    for (Employee employee : list) {
			Organization organization=om.queryOrname(Integer.parseInt(employee.getSpare1()));
			employee.setOname(organization.getName());
		}
		
		return p.toPageInfo();
	
	}









	@Override
	public Employee employeelogin(Employee employee) {
		// TODO Auto-generated method stub
		return em.employeelogin(employee);
	}

	
	
	
}
