package com.accp.dl.service;

import java.util.List;

import com.accp.domain.Employee;
import com.accp.domain.EmployeeExample;
import com.github.pagehelper.PageInfo;

public interface employeeService {
	
	
    List<Employee> selectByExample(EmployeeExample example);
    
	
	/**
	 * 分页查询
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageInfo<Employee> selecQueryFeYue(Integer currentPage,String employeename,Integer pageSize);
	
	
    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Employee selectById(Integer id);
	
	
	
	
    
}
