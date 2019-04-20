package com.accp.hmf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Customerss;
import com.accp.domain.Employee;
import com.accp.hmf.service.CustomerService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService cs;
    
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
    public String tocustomerquerypage() {
    	return "member-list";
    }
	
}
