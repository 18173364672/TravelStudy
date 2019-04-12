package com.accp.hmf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.EmployeeMapper;
import com.accp.dao.OrganizationMapper;
import com.accp.dao.RoyaltyMapper;
import com.accp.domain.Employee;
import com.accp.domain.Organization;
import com.accp.domain.OrganizationExample;
import com.accp.domain.Royalty;
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
	@Autowired
	RoyaltyMapper rm;
    
	@Override
	public PageInfo<Employee> querypage(Integer currentPage, Integer pageSize,String createtime,String employeename) {
		// TODO Auto-generated method stub
		Page<Employee> p = PageHelper.startPage(currentPage, pageSize,true);
	    List<Employee> list=em.empquery(createtime, employeename);
	    for (Employee employee : list) {
	    	int count=rm.queryemp(employee.getId());
	    	if(count==0) {
	    		employee.setSumpay(employee.getPay());
	    	}else {
	    		Double sumpay=0.0;
	    		 List<Royalty> rlist=rm.querypay(employee.getId());
	    		 for (Royalty r : rlist) {
				     sumpay+=r.getBasepay();
				}
	    		 employee.setSumpay(employee.getPay()+sumpay);
	    	}
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

	@Override
	public List<Organization> selectByExample(OrganizationExample example) {
		// TODO Auto-generated method stub
		return om.selectByExample(null);
	}

	@Override
	public Organization queryOrname(Integer id) {
		// TODO Auto-generated method stub
		return om.queryOrname(id);
	}

	@Override
	public int insertSelective(Employee record) {
		// TODO Auto-generated method stub
		return em.insert(record);
	}

	@Override
	public int updateByPrimaryKey(Organization record) {
		// TODO Auto-generated method stub
		return om.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(Employee record) {
		// TODO Auto-generated method stub
		return em.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return em.deleteByPrimaryKey(id);
	}

	@Override
	public Employee emqueryd(Integer id) {
		// TODO Auto-generated method stub
		return em.emqueryd(id);
	}

	@Override
	public int queryemp(Integer id) {
		// TODO Auto-generated method stub
		return rm.queryemp(id);
	}

	@Override
	public List<Royalty> querypay(Integer id) {
		// TODO Auto-generated method stub
		return rm.querypay(id);
	}

	
	
	
}
