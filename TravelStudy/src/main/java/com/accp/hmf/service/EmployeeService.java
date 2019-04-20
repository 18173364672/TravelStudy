package com.accp.hmf.service;

import java.util.List;

import com.accp.domain.Employee;
import com.accp.domain.Organization;
import com.accp.domain.OrganizationExample;
import com.accp.domain.Royalty;
import com.github.pagehelper.PageInfo;

public interface EmployeeService {
	//员工登陆
    public Employee employeelogin(Employee employee);
    
    //员工信息分页
    public PageInfo<Employee> querypage(Integer currentPage,Integer pageSize,String createtime,String employeename);
   
    //所有部门
    List<Organization> selectByExample(OrganizationExample example);
    
    //查询部门名称
    public Organization queryOrname(Integer id);
    
    //新增员工
    int insertSelective(Employee record);
    
    
    //修改部门信息
    int updateByPrimaryKey(Organization record);
    
    //修改员工信息
    int updateByPrimaryKey(Employee record);
    
    //删除员工信息
    int deleteByPrimaryKey(Integer id);
    
    //查询单个员工
    public Employee emqueryd(Integer id);
    
    //查询是否员工有提成
    int queryemp(Integer id);
    
    //查询员工所有提成
    List<Royalty> querypay(Integer id);
    
    //查询员工姓名
    String emqueryname(Integer id);
    
    public List<Employee> queryjl(String job);
    
}
