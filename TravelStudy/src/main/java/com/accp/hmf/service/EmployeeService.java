package com.accp.hmf.service;

import com.accp.domain.Employee;

import com.github.pagehelper.PageInfo;

public interface EmployeeService {
    public Employee employeelogin(Employee employee);
    
    public PageInfo<Employee> querypage(Integer currentPage,Integer pageSize,String createtime,String employeename);
}
