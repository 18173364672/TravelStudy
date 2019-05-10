package com.accp.hmf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.EmployeeMapper;
import com.accp.dao.OrganizationMapper;
import com.accp.dao.OrganizationzwMapper;
import com.accp.domain.Employee;
import com.accp.domain.Organization;
import com.accp.domain.Organizationzw;
import com.accp.hmf.service.OrganizationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class OrganizationServiceimpl implements OrganizationService{
    
	@Autowired
	OrganizationMapper om;
	@Autowired
	EmployeeMapper em;
	@Autowired
	OrganizationzwMapper oim;
	
	@Override
	public PageInfo<Organization> querypage(Integer currentPage, Integer pageSize, String name) {
		// TODO Auto-generated method stub
		Page<Organization> p = PageHelper.startPage(currentPage, pageSize,true);
		List<Organization> list=om.orpquery(name);
		return p.toPageInfo();
	}

	@Override
	public int insertSelective(Organization record) {
		// TODO Auto-generated method stub
		return om.insertSelective(record);
	}

	@Override
	public Organization queryOrname(Integer id) {
		// TODO Auto-generated method stub
		return om.queryOrname(id);
	}

	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return om.deleteByPrimaryKey(id);
	}

	@Override
	public List<Employee> emquerybm(Integer id) {
		// TODO Auto-generated method stub
		return em.emquerybm(id);
	}

	@Override
	public int insertSelective(Organizationzw organizationzw) {
		// TODO Auto-generated method stub
		return oim.insertSelective(organizationzw);
	}

	@Override
	public List<Organizationzw> queryzw(Integer id) {
		// TODO Auto-generated method stub
		return oim.queryzw(id);
	}

	@Override
	public int deletezw(Integer id) {
		// TODO Auto-generated method stub
		return oim.deletezw(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Organization record) {
		// TODO Auto-generated method stub
		return om.updateByPrimaryKeySelective(record);
	}
     
	
	
}
