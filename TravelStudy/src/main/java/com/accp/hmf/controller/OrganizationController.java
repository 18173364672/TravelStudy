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
import com.accp.domain.Organizationzw;
import com.accp.hmf.service.OrganizationService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
	@Autowired
	OrganizationService os;
	
	
	//删除职位
	@RequestMapping("/organizationzwdelete")
	public String organizationzwdelete(Integer id,Integer bmid) {
		os.deletezw(id);
		return "redirect:/organization/toorganizationedit?id="+bmid;
	}
	
	
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
	
	//部门修改
	@RequestMapping("/organizationedit")
	public String organizationedit(@RequestBody Organization organization) {
		os.updateByPrimaryKey(organization);
		for (Organizationzw oz : organization.getOlist()) {
			os.deletezw(oz.getId());
		}
		
		for (Organizationzw oz1 : organization.getOlist()) {
			 oz1.setOrganizationid(organization.getId());
			 os.insertSelective(oz1);
		}
	
		
		return "redirect:/organization/toorganizationedit?id="+organization.getId();
		
	}
	
	//跳转到部门修改页面
	@RequestMapping("/toorganizationedit")
	public String toorganizationedit(Model model,Integer id) {
		
		Organization organization=os.queryOrname(id);
		List<Organizationzw> list=os.queryzw(id);
		model.addAttribute("list", list);
		model.addAttribute("organization", organization);
		
		return "member-organization-edit";
	}
	
	//部门新增
	@RequestMapping("/organizationadd")
	@ResponseBody
	public Organization organizationadd(@RequestBody Organization organization) {
		os.insertSelective(organization);
		for (Organizationzw oz : organization.getOlist()) {
			Organizationzw oz1=new Organizationzw();
			oz1.setOrganizationid(organization.getId());
			oz1.setNamess(oz.getNamess());
			os.insertSelective(oz1);
			
		}
		
		
		return organization;
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
