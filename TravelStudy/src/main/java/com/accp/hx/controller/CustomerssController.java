package com.accp.hx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Customerss;
import com.accp.hx.service.CustomerssService;

@Controller
@RestController
@RequestMapping("/customersscontroller") 
public class CustomerssController {

	@Autowired
	CustomerssService customerssService;
	
	@RequestMapping("/dl")
	public Customerss dl(String Username,String UserPassWord) {
		Customerss list=customerssService.dl(Username,UserPassWord);
		System.out.println("pdasb");
		return list;	
	}
}
