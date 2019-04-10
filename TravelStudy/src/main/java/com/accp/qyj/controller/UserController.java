package com.accp.qyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController {
	
	
	@RequestMapping("/tologin")
	public String tologin() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
