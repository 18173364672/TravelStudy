package com.accp.qyj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.domain.Employee;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@RequestMapping("/tologin")
	public String tologin() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(String username , String password , HttpServletRequest req) {
		System.out.println("User login!");
		System.out.println(username);
		System.out.println(password);
		if(username.equals("111") && password.equals("222")) {
			System.out.println(username);
			System.out.println(password);
			Employee e = new Employee();
			e.setEmail(username);
			e.setPassword(password);
			req.getSession().setAttribute("user", e);
			return "redirect:/user/index";
		}
		return "redirect:/user/tologin";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}
