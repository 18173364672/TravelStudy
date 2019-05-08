package com.accp.qyj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Employee;
import com.accp.domain.Plate;
import com.accp.qyj.service.OrderService;
import com.accp.qyj.service.PlateService;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderservice;
	
	@Autowired
	PlateService plateservice;
	
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
		JSON.toJSONString(orderservice.queryOrderDetail(oid));
		return "manage-order-detail";
	}
	
	@RequestMapping("/detaildel")
	@ResponseBody
	public int detaildel(Integer id) {
		return orderservice.deleteOrderDetail(id);
	}
	
	@RequestMapping("/member-project-group-up")
	public String member_project_group_up(Model model , Integer id) {
		
		return "member-project-group-up";
	}
}