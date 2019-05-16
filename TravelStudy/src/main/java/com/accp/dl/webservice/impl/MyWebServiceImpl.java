package com.accp.dl.webservice.impl;

import javax.jws.WebService;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accp.dl.service.noticeService;
import com.accp.dl.webservice.MyWebService;
import com.accp.domain.Employee;

//@WebService("/mywebsocket")
@WebService(targetNamespace="http://webservice.accp.com"
,endpointInterface="com.accp.dl.webservice.MyWebService")
@Component
public class MyWebServiceImpl implements MyWebService{
	
	
	@Autowired
	noticeService noticeService;

	@Override
	public int toAdd(String title, String content,int uid, String spare1) {
		noticeService.toAdd(title, content, uid, spare1);
		return 0;
	}
	
	

}
