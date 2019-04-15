package com.accp.pda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.domain.Activity;
import com.accp.pda.service.ActivityService;

@Controller
public class ActivtyController {

	@Autowired
	ActivityService service;
	
	@RequestMapping("/query")
	public String query(Model model) {
		
		List<Activity> list = service.selectByExample(null);
		model.addAttribute("list", list);
		return "manage-activity";
	}
}
