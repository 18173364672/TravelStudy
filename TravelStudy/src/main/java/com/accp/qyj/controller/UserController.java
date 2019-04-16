package com.accp.qyj.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Employee;
import com.accp.domain.Organization;
import com.accp.domain.Plate;
import com.accp.domain.Role;
import com.accp.domain.Roleplate;
import com.accp.hmf.service.EmployeeService;
import com.accp.qyj.service.PlateService;
import com.accp.qyj.service.RoleService;
import com.accp.qyj.service.RoleplateService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	PlateService plateservice;
	
	@Autowired
	RoleService roleservice;
	
	@Autowired
	RoleplateService roleplateservice;
	
	@Autowired
    EmployeeService es;
	
	
	@RequestMapping("/tologin")
	public String tologin() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(Employee e, HttpServletRequest req) {
		if(es.employeelogin(e) != null) {
			req.getSession().setAttribute("user", es.employeelogin(e));
			return "redirect:/user/index";
		}
		return "redirect:/user/tologin";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	
	
	@RequestMapping("/usertoadd")
	public String usertoadd(Model model) {
		List<Organization> list=es.selectByExample(null);
  	  	model.addAttribute("list", list);
		return "manage-user-add";
	}
	
	@RequestMapping("/useradd")
	public String useradd(Employee employee) {
		employee.setCreatetime(new Date());
  	  employee.setState(1);
  	 es.insertSelective(employee);
  	 Organization organization=es.queryOrname(Integer.parseInt(employee.getSpare1()));
  	 int count=organization.getCount()+1;
  	 organization.setCount(count);
  	 es.updateByPrimaryKey(organization);
		return "redirect:/user/queryuser";
	}
	
	
	@RequestMapping("/usertoupdate")
	public String usertoupdate(Model model,Integer id) {
		Employee employee=es.emqueryd(id);
  	  	List<Organization> list=es.selectByExample(null);
  	  	model.addAttribute("list", list);
  	  	model.addAttribute("employee", employee);
		return "manage-user-update";
	}
	
	@RequestMapping("/userupdate")
	public String userupdate(Employee employee) {
		es.updateByPrimaryKey(employee);
		return "redirect:/user/queryuser";
	}
	
	
	
	@RequestMapping("/plate")
	public String plate(Model model , String name , Integer currentPage , Integer pageSize) {
		if("null".equals(name)) {
			name = null;
		}
		if(currentPage == null || currentPage<=1) {
			currentPage = 1;
		}
		if(pageSize == null) {
			pageSize = 5;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("name", name);
		model.addAttribute("page", plateservice.queryByPage(currentPage, pageSize, name));
		return "manage-plate";
	}
	
	@RequestMapping("/plateAdd")
	public String plateAdd(Model model) {
		model.addAttribute("list", plateservice.selectByExample(null));
		return "manage-plate-add";
	}
	
	@RequestMapping("/platetoAdd")
	public String platetoAdd(Plate plate) {
		plateservice.insert(plate);
		return "redirect:/user/plate";
	}
	
	@RequestMapping("/platedel")
	@ResponseBody
	public int platedel(Integer pid) {
		return plateservice.deleteByPrimaryKey(pid);
	}
	
	@RequestMapping("/platedelAll")
	@ResponseBody
	public int platedelAll(Integer[] pid) {
		return plateservice.deleteAll(pid);
	}
	
	@RequestMapping("/platetoupdate")
	public String platetoupdate(Integer pid,Model model) {
		model.addAttribute("plate1",plateservice.selectByPrimaryKey(pid));
		model.addAttribute("list", plateservice.selectByExample(null));
		return "manage-plate-update";
	}
	
	@RequestMapping("/plateupdate")
	public String plateupdate(Plate plate) {
		plateservice.updateByPrimaryKey(plate);
		return "redirect:/plate";
	}
	
	
	
	
	@RequestMapping("/role")
	public String role(Model model , String name , Integer currentPage , Integer pageSize) {
		if("null".equals(name)) {
			name = null;
		}
		if(currentPage == null || currentPage<=1) {
			currentPage = 1;
		}
		if(pageSize == null) {
			pageSize = 5;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("name", name);
		model.addAttribute("page", roleservice.queryByPage(currentPage, pageSize, name));
		return "manage-role";
	}
	
	@RequestMapping("/roleAdd")
	public String roleAdd(Model model) {
		model.addAttribute("list", plateservice.selectByExample(null));
		return "manage-role-add";
	}
	
	@RequestMapping("/roletoAdd")
	public String roletoAdd(Role role) {
		roleservice.insert(role);
		Roleplate roleplate = new Roleplate();
		for (int i = 0; i < role.getPid().length; i++) {
			roleplate.setPid(role.getPid()[i]);
			roleplate.setRid(role.getRid());
			roleplateservice.insert(roleplate);
		}
		return "redirect:/user/role";
	}
	
	@RequestMapping("/roledel")
	@ResponseBody
	public int roledel(Integer rid) {
		return roleservice.deleteByPrimaryKey(rid);
	}
	
	@RequestMapping("/roledelAll")
	@ResponseBody
	public int roledelAll(Integer[] rid) {
		return roleservice.deleteAll(rid);
	}
	
	@RequestMapping("/roletoupdate")
	public String roletoupdate(Integer rid,Model model) {
		model.addAttribute("role1",roleservice.selectByPrimaryKey(rid));
		model.addAttribute("list1", roleplateservice.querybyid(rid));
		model.addAttribute("list", plateservice.selectByExample(null));
		return "manage-role-update";
	}
	
	@RequestMapping("/roleupdate")
	public String roleupdate(Role role , Integer[] id) {
		roleservice.updateByPrimaryKey(role);
		Roleplate rp = new Roleplate();
		rp.setRid(role.getRid());
		roleplateservice.deleteByRid(role.getRid());
		
		for (int i = 0; i < role.getPid().length; i++) {
			rp.setPid(role.getPid()[i]);
			roleplateservice.insert(rp);
		}
		return "redirect:/user/role";
	}
	
	@RequestMapping("/roleDetails")
	public String roleDetails(Integer rid , String name , Model model) {
		model.addAttribute("name", name);
		model.addAttribute("list", plateservice.queryPlate(rid));
		return "manage-role-details";
	}
	
	
	@RequestMapping("/queryuser")
	public String queryuser() {
		return "manage-user";
	}
	
    //员工信息分页
    @RequestMapping("/user")
    @ResponseBody
    public  PageInfo<Employee> querypage(Integer currentPage,String createtime,String employeename) {
   
		   if(currentPage==null) {
			   currentPage = 1;
		   }
		   PageInfo<Employee> pageInfo = es.querypage(currentPage,5,createtime,employeename);
//			model.addAttribute("page",pageInfo);
			
			return pageInfo;
    }
    
    //员工修改
    @RequestMapping("/employeeedit")
    public String employeeedit(Employee employee) {
  	    es.updateByPrimaryKey(employee);
  	
  	  return "redirect:/user/queryuser";
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
    
    
}
