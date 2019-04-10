package com.accp.hmf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Employee;

import com.accp.hmf.service.EmployeeService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
      @Autowired
      EmployeeService es;
      
      @RequestMapping("/toemployeeadd")
      public String toemployeeadd() {
    	  return "member-employee-add";
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
