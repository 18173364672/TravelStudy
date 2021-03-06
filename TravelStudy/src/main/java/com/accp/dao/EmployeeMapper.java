package com.accp.dao;

import com.accp.domain.Employee;
import com.accp.domain.EmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    int countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    
    public Employee employeelogin(Employee employee);
    
    public List<Employee> empquery(@Param("createtime")String createtime,@Param("employeename")String employeename);

    public Employee emqueryd(Integer id);
    
    List<Employee> emquerybm(Integer id);
    /**
     * 分页带条件查询
     * @param employeename
     * @return
     */
    List<Employee> selecQueryFeYue(String employeename);
    
    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Employee selectById(Integer id);
    
     String emqueryname(Integer id);
    
    List<Employee> queryjl(@Param("job") String job);
}