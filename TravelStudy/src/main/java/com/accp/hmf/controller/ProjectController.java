package com.accp.hmf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Employee;
import com.accp.domain.Field;
import com.accp.domain.Fieldtype;
import com.accp.domain.Project;
import com.accp.hmf.service.EmployeeService;
import com.accp.hmf.service.FieldService;
import com.accp.hmf.service.ProjectService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	ProjectService ps;
	@Autowired
	FieldService fs;
	@Autowired
	EmployeeService em;
	
	@RequestMapping("/queryjl")
	@ResponseBody
	public List<Employee> queryjl(Integer fid) {
		Fieldtype fieldtype=fs.queryfname(fid);
		String job=fieldtype.getName();
		List<Employee> elist=em.queryjl(job);
		
		return elist;
	}
	
	@RequestMapping("/toprojectadd")
	public String toprojectadd(Model model,String name) {
		
		List<Fieldtype> list=fs.selectByExample(null);
		model.addAttribute("list", list);
		return "member-project-add";
	}
	
	@RequestMapping("/projectquerypage")
	@ResponseBody
	 public PageInfo<Project> querypage(Integer currentPage,String projectname){
   	 if(currentPage==null) {
			   currentPage = 1;
		   }
   	 
   	 PageInfo<Project> pageInfo=ps.querypage(currentPage, 1, projectname);
   	    return pageInfo;
    }
	
	
	@RequestMapping("/toprojectquerypage")
	public String toprojectquerypage() {
		
		return "member-project";
	}
	

}
