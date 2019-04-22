package com.accp.pda.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Activity;
import com.accp.domain.Employee;
import com.accp.domain.Plate;
import com.accp.pda.service.ActivityService;
import com.accp.qyj.service.PlateService;

@Controller
public class ActivtyController {

	@Autowired
	ActivityService service;
	
	@Autowired
	PlateService plateservice;
	
	@RequestMapping("/query")
	public String query(Model model , HttpSession session) {
		Employee es = (Employee)session.getAttribute("user");
		List<Plate> plate = plateservice.queryLeftNav(es.getId());
		model.addAttribute("plist", plate);
		List<Activity> list = service.selectByExample(null);
		model.addAttribute("list", list);
		return "manage-activity";
	}
	
	@RequestMapping("/queryByid")
	public String queryId(Integer id,Model model) {
		Activity ac = service.selectByPrimaryKey(id);
		model.addAttribute("ac", ac);
		return "manage-activity-jieshao";
	}
	
	@RequestMapping("/queryByName")
	public String queryId(String name,Model model) {
		List<Activity> list = service.selectByName(name);
		System.out.println(list);
		model.addAttribute("list", list);
		return "manage-activity";
	}
	
	
	@RequestMapping("/update")
	public String queryUpdate(Activity activity) {
		service.updateByPrimaryKey(activity);
		return "redirect:query";
	}
	
	
	@RequestMapping("/updateQuery")
	public String updateQuery(Integer id,Model model) {
		Activity activityUp = service.selectByPrimaryKey(id);
		model.addAttribute("activityUp",activityUp);
		return "manage-activity-up";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Integer id) {
		System.out.println(id);
		service.deleteByPrimaryKey(id);
		return "";
	}
	
	@RequestMapping("/insert")
	public String insert(Activity activity) {
		return "manage-activity-add";
	}
	
	@RequestMapping("/queryProject")
	public String queryPriject() {
		return "manage-activity-show";
	}
}
