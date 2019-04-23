package com.accp.hmf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    HttpServletResponse response;
    
    
    @RequestMapping("/customerupstates")
    public String customerupstates(Integer id) {
    	Customerss customerss=new Customerss();
    	customerss.setId(id);
    	customerss.setState(0);
    	cs.updateByPrimaryKeySelective(customerss);
    	
    	return "redirect:/customer/tocustomerquerypage";
    }
    
    @RequestMapping("/customerupstate")
    public String customerupstate(@RequestBody Customerss customerss) {
    	for (Customerss c : customerss.getMlist()) {
			c.setState(0);
			cs.updateByPrimaryKeySelective(c);
		}
    	
    	
    	return "redirect:/customer/tocustomerquerypage";
    }
    
    @RequestMapping("/customeredit")
    public String customeredit(Customerss customerss) {
    	
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
    	 Integer year=Integer.parseInt(df.format(new Date()));
    	 String idcard=customerss.getIdcard();
    	 
    	 Integer nl=Integer.parseInt(idcard.substring(6, 10));
    	 Integer nl1=year-nl;
    	 
    	 customerss.setSpare2(nl1.toString());
    	 
    		if(customerss.getGroupname().equals("无")) {
        		customerss.setGroupid(0);
        	}else {
        		
        		
        		customerss.setGroupid(Integer.parseInt(customerss.getGroupname()));
        	}
    		
    		cs.updateByPrimaryKeySelective(customerss);
    	
    
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=utf-8");
    	PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<script>");
		    out.println("alert('修改成功！');");
		    out.println("history.back();");
		    out.println("var index=parent.layer.getFrameIndex(window.name);");
		    out.println("parent.layer.close(index)");
		    out.println("window.parent.location.reload();");
		    out.println("</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return "member-edit";
    	
    	
   
    }
   
    
    @RequestMapping("/tocustomeredit")
    public String tocustomeredit(Model model,Integer id) {
    	
    	List<Customergroup> list=cgs.selectByExample(null);
    	model.addAttribute("list", list);
    	
    	Customerss customerss=cs.cuqueryd(id);
    	
    	model.addAttribute("customerss", customerss);
    	return "member-edit";
    }
    
    @RequestMapping("/customeradd")
    public String customeradd(Customerss customerss) {
    	
    	
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
    	 Integer year=Integer.parseInt(df.format(new Date()));
    	 String idcard=customerss.getIdcard();
    	 
    	 Integer nl=Integer.parseInt(idcard.substring(6, 10));
    	 Integer nl1=year-nl;
    	 
    	 customerss.setSpare2(nl1.toString());
    	 
        // new Date()为获取当前系统时间
    	
    	customerss.setCreatetime(new Date());
    	customerss.setConsumption(0.0);
    	customerss.setConsume(0);
    	customerss.setState(1);
    	
    	if(customerss.getGroupname().equals("无")) {
    		customerss.setGroupid(0);
    	}else {
    		
    		
    		customerss.setGroupid(Integer.parseInt(customerss.getGroupname()));
    	}
    	
    	int count=cs.insertSelective(customerss);
    	
    	Customergroup customergroup=new Customergroup();
    	customergroup.setFid(customerss.getId());
    	customergroup.setId(Integer.parseInt(customerss.getGroupname()));
    	System.out.println(customergroup.getFid());
    	System.out.println(customergroup.getId());
    	int count1=cgs.updateByPrimaryKeySelective(customergroup);
    	
    		
    		response.setCharacterEncoding("UTF-8");
        	response.setContentType("text/html; charset=utf-8");
        	PrintWriter out;
    		try {
    			out = response.getWriter();
    			out.println("<script>");
    		    out.println("alert('新增成功！');");
    		    out.println("var index=parent.layer.getFrameIndex(window.name);");
    		    out.println("parent.layer.close(index)");
    		    out.println("window.parent.location.reload();");
    		   
    		  
    		    
    		    out.println("</script>");
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		
    
    	
    	return "member-add";
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
