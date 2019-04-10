package com.accp.zjq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Project;
import com.accp.zjq.service.ProjectService;

@Controller
public class TjController {
	
	@Autowired
	ProjectService psi;
	
	@RequestMapping("/toRqProject")
	public String toRqProject(Model model) {
		System.out.println("加载项目人气页面中...");
//		//查询所有项目
//		List<Project>projects = psi.queryAllProject();
//		for (Project project : projects) {
//			System.out.println(project.getProjectname());
//		}
//		model.addAttribute("project", projects);
		return "echarts1";
	}
	
	@RequestMapping("/ajaxToQuery")
	@ResponseBody
	public List<Project> ajaxToQuery() {
		List<Project>projects = psi.queryAllProject();
		
		return projects;
	}
	
	@RequestMapping("toMonthSr")
	public String toMonthSr() {
		return "echarts2";
	}
	
	@RequestMapping("toRqTeacher")
	public String toRqTeacher() {
		return "echarts3";
	}
	
	@RequestMapping("toRqActivity")
	public String toRqActivity() {
		return "echarts4";
	}
	
	@RequestMapping("toMothKh")
	public String toMothKh() {
		return "echarts5";
	}
	
	@RequestMapping("toYgKq")
	public String toYgKq() {
		return "echarts6";
	}
	
	@RequestMapping("toQuestion")
	public String toQuestion() {
		return "echarts7";
	}
	
}
