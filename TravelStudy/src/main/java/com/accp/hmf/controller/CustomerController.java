package com.accp.hmf.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Customergroup;
import com.accp.domain.Customerss;
import com.accp.domain.Employee;
import com.accp.hmf.service.CustomerService;
import com.accp.hmf.service.CustomergroupService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService cs;
    @Autowired
    CustomergroupService cgs;
    
    @RequestMapping("/customeradd")
    public String customeradd(Customerss customerss) {
    	
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
    	 Integer year=Integer.parseInt(df.format(new Date()));
    	 String idcard=customerss.getIdcard();
    	 System.out.println(idcard);
    	 Integer nl=Integer.parseInt(idcard.substring(6, 10));
    	 Integer nl1=year-nl;
    	 
    	 customerss.setSpare2(nl1.toString());
    	 
        // new Date()为获取当前系统时间
    	
    	customerss.setCreatetime(new Date());
    	customerss.setConsumption(0.0);
    	customerss.setConsume(0);
    	customerss.setState(1);
    	String groupname="";
    	if(customerss.getGroupname().equals("无")) {
    		customerss.setGroupid(0);
    	}else {
    		groupname=customerss.getGroupname();
    		int groupid= cgs.groupid(groupname);
    		customerss.setGroupid(groupid);
    	}
    	
    	cs.insertSelective(customerss);
    	return "redirect:/customer/tocustomeradd";
    }
    
    @RequestMapping("/tocustomeradd")
    public String tocustomeradd(Model model) {
    	List<Customergroup> list=cgs.selectByExample(null);
    	model.addAttribute("list", list);
    	
    	return "member-add";
    }
    
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
