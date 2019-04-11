package com.accp.hmf.service;

import java.util.List;

import com.accp.domain.Employee;
import com.accp.domain.Organization;
import com.accp.domain.OrganizationExample;
import com.github.pagehelper.PageInfo;

public interface EmployeeService {
    public Employee employeelogin(Employee employee);
    
    public PageInfo<Employee> querypage(Integer currentPage,Integer pageSize,String createtime,String employeename);

    List<Organization> selectByExample(OrganizationExample example);
    
    public Organization queryOrname(Integer id);
    
    int insertSelective(Employee record);
    
    int updateByPrimaryKey(Organization record);
    
    int updateByPrimaryKey(Employee record);
    
    int deleteByPrimaryKey(Integer id);
    
    public Employee emqueryd(Integer id);
    
    
}
