package com.accp.dl.controller;

import org.apache.xml.resolver.apps.resolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.dl.service.impl.noticeServiceImpl;
import com.accp.domain.Notice;

@Controller
@RequestMapping("/notice")
public class notice {

	
	@Autowired
	noticeServiceImpl notices;
	
	
	
	
	/**
	 * 开始的主页
	 * @return
	 */
	@RequestMapping("/query")
	public String index() {
		return "index";
	}
	
	/**
	 * 跳转公告管理
	 * @return
	 */
	@RequestMapping("/member")
	public String member() {
		return "member-employee-kiss";
	}
	
	/**
	 * 跳转全公司发送
	 * @return
	 */
	@RequestMapping("/company")
	public String company() {
		return "member-employee-kiss-company";
	}
	
	/**
	 * 跳转员工发送
	 * @return
	 */
	@RequestMapping("/DanFaBu")
	public String DanFaBu() {
		return "DanFaBu";
	}
	
	/**
	 * 跳转部门发送
	 * @return
	 */
	@RequestMapping("/organization")
	public String organization() {
		return "member-employee-kiss-organization";
	}
	
	
	/**
	 * 群发公司所有员工
	 * @param notice
	 * redirect:
	 * @return
	 */
	@RequestMapping("/addnotice")
	public String addnotice(Notice notice) {
		notice.setUid(1);
		notices.add(notice);
		return "redirect:member";
	}
	
	
	
	
}
