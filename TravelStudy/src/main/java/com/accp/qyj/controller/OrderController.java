package com.accp.qyj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Activity;
import com.accp.domain.Customergroup;
import com.accp.domain.Employee;
import com.accp.domain.Eventitems;
import com.accp.domain.Order;
import com.accp.domain.Orderdetail;
import com.accp.domain.Plate;
import com.accp.domain.Project;
import com.accp.hmf.service.CustomergroupService;
import com.accp.hmf.service.ProjectService;
import com.accp.pda.service.ActivityService;
import com.accp.qyj.service.EventitemsService;
import com.accp.qyj.service.OrderService;
import com.accp.qyj.service.OrderdetailService;
import com.accp.qyj.service.PlateService;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderservice;
	
	@Autowired
	PlateService plateservice;
	
	@Autowired
	ActivityService activityservice;
	
	@Autowired
	ProjectService projectservice;
	
	@Autowired
	CustomergroupService customergroupservice;
	
	@Autowired
	EventitemsService eventitemsservice;
	
	@Autowired
	OrderdetailService orderdetailservice;
	
	@RequestMapping("/query")
	public String query(Model model , HttpSession session ,HttpServletResponse response, String name , Integer currentPage , Integer pageSize , Integer pages) {
		if(currentPage == null || currentPage < 1) {
			currentPage = 1 ;
		}
		if(pages != null && currentPage > pages) {
			currentPage = pages;
		}
		
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
		
		model.addAttribute("page", orderservice.queryByPage(name, currentPage, pageSize));
		model.addAttribute("currentPage", currentPage);
		return "manage-order";
	}
	
	
	@RequestMapping("/detail")
	public String detail(Model model , Integer oid) {
		model.addAttribute("list", orderservice.queryOrderDetail(oid));
		return "manage-order-detail";
	}
	
	@RequestMapping("/detaildel")
	@ResponseBody
	public int detaildel(Integer id) {
		return orderservice.deleteOrderDetail(id);
	}
	
	@RequestMapping("/member-project-group-up")
	public String member_project_group_up(Model model) {
		model.addAttribute("alist", activityservice.query(null));
		model.addAttribute("ilist", projectservice.pquery(null));
		model.addAttribute("glist", customergroupservice.cgquerypage(null));
		return "manage-order-add";
	}
	
	@RequestMapping("/activity")
	@ResponseBody
	public List<Activity> activity(String name) {
		return activityservice.query(name);
	}
	
	@RequestMapping("/project")
	@ResponseBody
	public List<Project> project(String name) {
		return projectservice.pquery(name);
	}
	
	@RequestMapping("/khz")
	@ResponseBody
	public List<Customergroup> khz(String name) {
		return customergroupservice.cgquerypage(name);
	}
	
	@RequestMapping("/addorder")
	@ResponseBody
	public int addorder( Integer[] activityid , Integer[] itemid , Integer kh) {
		Customergroup khz = customergroupservice.groupname(kh);
		Double zj = 0.0;
		Order o = new Order();
		o.setYid(khz.getFid());
		o.setSid(4);
		o.setTime(new Date());
		o.setPrice(0.0);
		o.setTid(1);
		o.setLid(3);
		orderservice.insertSelective(o);
//		orderdetailservice.qeuryid(o);
		for (int i = 0; i < activityid.length; i++) {
			List<Eventitems> e = eventitemsservice.eveselect(activityid[i]);
			for (Eventitems eventitems : e) {
				for (Project p : eventitems.getProlist()) {
					Orderdetail od = new Orderdetail();
					od.setOid(o.getId());
//					od.setFid(1);
//					od.setStarttime(new Date());
//					od.setEndtime(new Date());
					od.setPid(p.getId());
					od.setDj(p.getPrice());
					zj+=p.getPrice();
					orderdetailservice.insertSelective(od);
				}
			}
		}
		for (int i = 0; i < itemid.length; i++) {
			Project p = projectservice.queryd(itemid[i]);
			Orderdetail od = new Orderdetail();
			od.setOid(o.getId());
//			od.setFid(1);
//			od.setStarttime(new Date());
//			od.setEndtime(new Date());
			od.setPid(p.getId());
			od.setDj(p.getPrice());
			zj+=p.getPrice();
			orderdetailservice.insertSelective(od);
		}
		orderdetailservice.queryTime(o.getId());
		
		o.setPrice(zj);
		orderservice.updateByPrimaryKeySelective(o);
		return 0;
	}
	
	@RequestMapping("/projectDetails")
	public String projectDetails(Model model,Integer id) {
		model.addAttribute("list", projectservice.queryByaid(id));
		return "manage-activity-details";
	}
	
	
	@RequestMapping("/xiugai")
	public String xiugai(Model model,Integer id) {
		
		return "manage-order-detail-update";
	}
	
	
}
