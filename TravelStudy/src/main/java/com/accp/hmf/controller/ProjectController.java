package com.accp.hmf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Field;
import com.accp.domain.Project;
import com.accp.hmf.service.ProjectService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	ProjectService ps;
	
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
