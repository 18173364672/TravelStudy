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
import com.accp.domain.Organizationzw;
import com.accp.domain.Royalty;
import com.accp.hmf.service.EmployeeService;
import com.accp.hmf.service.OrganizationService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
      @Autowired
      EmployeeService es;
      @Autowired
      OrganizationService organizationService;
      
      //查询工资
      @RequestMapping("/querypay")
      public String querypay(Model model,Integer id) {
    	  Employee employee=es.emqueryd(id);
    	  int count=es.queryemp(id);
    	  if(count==0) {
    		  employee.setSumpay(employee.getPay());
    		  model.addAttribute("employee", employee);
    		 
    		  return "member-emp-show1";
    	  }else {
    		  Double sumpay=0.0;
    		  List<Royalty> list=es.querypay(id);
    		  for (Royalty royalty : list) {
				sumpay+=royalty.getBasepay();
			 }
    		  employee.setSumpay(employee.getPay()+sumpay);
    		  model.addAttribute("list", list);
    		  model.addAttribute("employee", employee);
    		
    		  return "member-emp-show";
    	  }
    	  
    	 
      }
      
      //更新密码
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
      
      //密码修改页面
      @RequestMapping("/employeeeditpass")
      public String employeeeditpass(Model model,Integer id) {
    	  Employee employee=es.emqueryd(id);
    	  model.addAttribute("employee", employee);
    	  return "member-employee-password";
      }
      
      
      //员工修改
      @RequestMapping("/employeeedit")
      public String employeeedit(Employee employee) {
    	  
            Employee em1=es.emqueryd(employee.getId());
            if(employee.getSpare1().equals(em1.getSpare1())) {
            	 es.updateByPrimaryKey(employee);
            	
            }else {
               Organization organization=es.queryOrname(Integer.parseInt(em1.getSpare1()));
          	  int count=organization.getCount()-1;
          	  organization.setCount(count);
          	 es.updateByPrimaryKey(organization);
          	  
          	Organization organization1=es.queryOrname(Integer.parseInt(employee.getSpare1()));
        	  int count1=organization1.getCount()+1;
        	  organization1.setCount(count1);
        	  es.updateByPrimaryKey(organization1);
        	  
        	  
        	  es.updateByPrimaryKey(employee);
        	  
            	
            }
            
    	  
    	   
    	    
    	    
    	
    	  return "redirect:/employee/toemployeeedit?id="+employee.getId();
      }
      
      //跳转到员工修改页面
      @RequestMapping("/toemployeeedit")
      public String toemployeeedit(Model model,Integer id) {
    	  Employee employee=es.emqueryd(id);
    	  List<Organization> list=es.selectByExample(null);
    	  model.addAttribute("list", list);
    	  model.addAttribute("employee", employee);
    	  return "member-employee-edit";
      }
      
      
      //删除单个员工并删除部门在职人数
      @RequestMapping("/deleteemployees")
      public String deleteemployees(Integer id,Integer spare1) {
    	  es.deleteByPrimaryKey(id);
    	  Organization organization=es.queryOrname(spare1);
    	  int count=organization.getCount()-1;
    	  organization.setCount(count);
    	  es.updateByPrimaryKey(organization);
    	  
    	  return "redirect:/employee/toemployeequerypage";
      }
      
      
      //删除多个员工并删除部门在职人数
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
      
      
      //更新状态，在职和离职
      @RequestMapping("/updatestate")
      public String updatestate(Integer id,Integer state) {
    	  Employee employee=new Employee();
    	  
    	  employee.setId(id);
    	  employee.setState(state);
    	  es.updateByPrimaryKey(employee);
    	  
    	  Employee e2=es.emqueryd(id);
    	  
    	  if(state==0) {
    		  Organization organization=es.queryOrname(Integer.parseInt(e2.getSpare1()));
    		  int count=organization.getCount()-1;
 	    	  organization.setCount(count);
 	    	  es.updateByPrimaryKey(organization);
    	  }else {
    		  Organization organization=es.queryOrname(Integer.parseInt(e2.getSpare1()));
    		  int count=organization.getCount()+1;
 	    	  organization.setCount(count);
 	    	  es.updateByPrimaryKey(organization);
    	  }
    	  
    	  
    	  
    	  return "redirect:/employee/toemployeequerypage";
      }
      
      
      //员工新增
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
      
      //跳转到员工新增页面
      @RequestMapping("/toemployeeadd")
      public String toemployeeadd(Model model) {
    	  List<Organization> list=es.selectByExample(null);
    	  model.addAttribute("list", list);
    	  return "member-employee-add";
      }
      
      @RequestMapping("/queryzw")
      @ResponseBody
      public List<Organizationzw> querybm(Integer id) {
    	 
    	 List<Organizationzw> list=organizationService.queryzw(id);
    	  
    	  return list;
      }
      
      
      //跳转到员工查询
      @RequestMapping("/toemployeequerypage")
      public String toemployeequerypage() {
    	  
    	  return "member-employee";
      }
      
      
      //员工信息分页
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
