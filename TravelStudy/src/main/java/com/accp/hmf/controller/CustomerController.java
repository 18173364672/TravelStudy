package com.accp.hmf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Customerss;
import com.accp.domain.Employee;
import com.accp.domain.Plate;
import com.accp.hmf.service.CustomerService;
import com.accp.qyj.service.PlateService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService cs;
    
    @Autowired
    PlateService plateservice;
    
    @RequestMapping("/customerquerypage")
    @ResponseBody
    public  PageInfo<Customerss> customerquerypage(Integer currentPage, Integer pageSize, String createtime, String username) {
    	 if(currentPage==null) {
			   currentPage = 1;
		   }
		   PageInfo<Customerss> pageInfo = cs.querypage(currentPage,3,createtime,username);
//			model.addAttribute("page",pageInfo);
			
			return pageInfo;
    	
    	
    	
    }
    
    
    @RequestMapping("/tocustomerquerypage")
    public String tocustomerquerypage(Model model , HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
    	return "member-list";
    }
	
}
