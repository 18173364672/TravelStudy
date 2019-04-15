package com.accp.hmf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Employee;
import com.accp.domain.Organization;
import com.accp.hmf.service.OrganizationService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
	@Autowired
	OrganizationService os;
	
	
	//查询部门对应员工
	@RequestMapping("/organizationquery")
	public String organizationquery(Model model,Integer id) {
		
		List<Employee> list=os.emquerybm(id);
		model.addAttribute("list", list);
		
		return "member-or-show";
	}
	
	
	//部门单个删除
	@RequestMapping("/organizationdeletes")
	public String organizationdeletes(Integer id) {
		os.deleteByPrimaryKey(id);
		return "redirect:/organization/organizationquerypage";
	}
	
	
	//部门多个删除
	@RequestMapping("/organizationdelete")
	public String organizationdelete(@RequestBody Organization organization) {
		for (Organization or : organization.getMlist()) {
			os.deleteByPrimaryKey(or.getId());
		}
		
		return "redirect:/organization/organizationquerypage";
	}
	
	@RequestMapping("/organizationedit")
	public String organizationedit(Organization organization) {
		os.updateByPrimaryKey(organization);
		return "redirect:/organization/toorganizationedit?id="+organization.getId();
		
	}
	
	//跳转到部门修改页面
	@RequestMapping("/toorganizationedit")
	public String toorganizationedit(Model model,Integer id) {
		
		Organization organization=os.queryOrname(id);
		model.addAttribute("organization", organization);
		
		return "member-organization-edit";
	}
	
	//部门新增
	@RequestMapping("/organizationadd")
	public String organizationadd(Organization organization) {
		os.insertSelective(organization);
		return "redirect:/organization/organizationquerypage";
	}
	
	//跳转到部门新增页面
	@RequestMapping("/toorganizationadd")
	public String toorganizationadd() {
		return "member-organization-add";
	}
	
	//跳转到查询页面
	@RequestMapping("/toorganization")
	public String toorganization() {
		return "member-organization";
	}
	
	
	//部门分页查询
	 @RequestMapping("/organizationquerypage")
     @ResponseBody
     public  PageInfo<Organization> querypage(Integer currentPage,String name) {
    
		   if(currentPage==null) {
			   currentPage = 1;
		   }
		   PageInfo<Organization> pageInfo = os.querypage(currentPage, 3, name);
//			model.addAttribute("page",pageInfo);
			
			return pageInfo;
	   }
	

}
