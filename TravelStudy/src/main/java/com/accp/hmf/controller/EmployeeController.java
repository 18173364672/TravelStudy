package com.accp.hmf.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Employee;
import com.accp.domain.Organization;
import com.accp.hmf.service.EmployeeService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
      @Autowired
      EmployeeService es;
      
      @RequestMapping("/updatepass")
      public String updatepass(@RequestBody Employee employee) {
    	  Employee employee2=es.emqueryd(employee.getId());
    	 
    	  
    	  if(!employee.getOldpass().equals(employee2.getPassword())||!employee.getNewpass().equals(employee.getRepass())) {
    		  throw new RuntimeException();
    	  }
    	  employee.setPassword(employee.getNewpass());
    	  es.updateByPrimaryKey(employee);
    	  
    	  return "redirect:/employee/employeeeditpass?id="+employee.getId();
      }
      
      @RequestMapping("/employeeeditpass")
      public String employeeeditpass(Model model,Integer id) {
    	  Employee employee=es.emqueryd(id);
    	  model.addAttribute("employee", employee);
    	  return "member-employee-password";
      }
      
      @RequestMapping("/employeeedit")
      public String employeeedit(Employee employee) {
    	    es.updateByPrimaryKey(employee);
    	
    	  return "redirect:/employee/toemployeeedit?id="+employee.getId();
      }
      
      @RequestMapping("/toemployeeedit")
      public String toemployeeedit(Model model,Integer id) {
    	  Employee employee=es.emqueryd(id);
    	  List<Organization> list=es.selectByExample(null);
    	  model.addAttribute("list", list);
    	  model.addAttribute("employee", employee);
    	  return "member-employee-edit";
      }
      
      @RequestMapping("/deleteemployees")
      public String deleteemployees(Integer id,Integer spare1) {
    	  es.deleteByPrimaryKey(id);
    	  Organization organization=es.queryOrname(spare1);
    	  int count=organization.getCount()-1;
    	  organization.setCount(count);
    	  es.updateByPrimaryKey(organization);
    	  
    	  return "redirect:/employee/toemployeequerypage";
      }
      
      @RequestMapping("/deleteemployee")
      public String deleteemployee(@RequestBody Employee employee) {
    	  List<Employee> list=employee.getMlist();
    	  for (Employee employee2 : list) {
			es.deleteByPrimaryKey(employee2.getId());
			Organization organization=es.queryOrname(Integer.parseInt(employee2.getSpare1()));
			 int count=organization.getCount()-1;
	    	 organization.setCount(count);
	    	 es.updateByPrimaryKey(organization);
		}
    	  
    	  
    	  return "redirect:/employee/toemployeequerypage";
      }
      
      @RequestMapping("/updatestate")
      public String updatestate(Integer id,Integer state) {
    	  Employee employee=new Employee();
    	  employee.setId(id);
    	  employee.setState(state);
    	  es.updateByPrimaryKey(employee);
    	  
    	  return "redirect:/employee/toemployeequerypage";
      }
      
      @RequestMapping("/employeeadd")
      public String employeeadd(Employee employee) {
    	  employee.setCreatetime(new Date());
    	  employee.setState(1);
    	 es.insertSelective(employee);
    	 Organization organization=es.queryOrname(Integer.parseInt(employee.getSpare1()));
    	 int count=organization.getCount()+1;
    	 organization.setCount(count);
    	 es.updateByPrimaryKey(organization);
    	  
    	  
    	  return "redirect:/employee/toemployeeadd";
      }
      
      @RequestMapping("/toemployeeadd")
      public String toemployeeadd(Model model) {
    	  List<Organization> list=es.selectByExample(null);
    	  model.addAttribute("list", list);
    	  return "member-employee-add";
      }
      
      @RequestMapping("/queryzw")
      @ResponseBody
      public Organization querybm(Integer id) {
    	 
    	  Organization organization=es.queryOrname(id);
    	  
    	  return organization;
      }
      
      @RequestMapping("/toemployeequerypage")
      public String toemployeequerypage() {
    	  
    	  return "member-employee";
      }
      
      
      @RequestMapping("/employeequerypage")
      @ResponseBody
      public  PageInfo<Employee> querypage(Integer currentPage,String createtime,String employeename) {
     
		   if(currentPage==null) {
			   currentPage = 1;
		   }
		   PageInfo<Employee> pageInfo = es.querypage(currentPage,5,createtime,employeename);
//			model.addAttribute("page",pageInfo);
			
			return pageInfo;
	   }
       
	
	
}
