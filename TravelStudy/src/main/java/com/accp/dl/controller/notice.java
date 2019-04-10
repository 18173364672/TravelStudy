package com.accp.dl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.domain.Notice;

@Controller
//@RequestMapping("/notice")
public class notice {

	/**
	 * 开始的主页
	 * @return
	 */
	@RequestMapping("/query")
	public String index() {
		return "index";
	}
	
	/**
	 * 群发公司所有员工
	 * @param notice
	 * @return
	 */
	@RequestMapping("/addnotice")
	public String addnotice(Notice notice) {
		
		
		
		return "member-employee-kiss";
	}
	
	
	
	
}
