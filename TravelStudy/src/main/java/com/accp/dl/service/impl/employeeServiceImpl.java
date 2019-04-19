package com.accp.dl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.EmployeeMapper;
import com.accp.dl.service.employeeService;
import com.accp.domain.Employee;
import com.accp.domain.EmployeeExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class employeeServiceImpl implements employeeService{

	@Autowired
	EmployeeMapper employ;
	
	/**
	 * 查询所有
	 */
	@Override
	public List<Employee> selectByExample(EmployeeExample example) {
		return employ.selectByExample(null);
	}

	
	/**
	 * 分页查询
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageInfo<Employee> selecQueryFeYue(Integer currentPage, String employeename, Integer pageSize) {
		Page<Employee> pageInfo = PageHelper.startPage(currentPage,pageSize,true);
		
		employ.selecQueryFeYue(employeename);
		
		return pageInfo.toPageInfo();
	}


	@Override
	public Employee selectById(Integer id) {
		return employ.selectById(id);
	}

	
	
	
}
