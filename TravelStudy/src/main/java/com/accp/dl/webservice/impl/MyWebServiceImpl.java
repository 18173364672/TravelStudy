package com.accp.dl.webservice.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accp.dl.service.noticeService;
import com.accp.dl.webservice.MyWebService;

@WebService(targetNamespace="http://webservice.accp.com"
,endpointInterface="com.accp.dl.webservice.MyWebService")
@Component
public class MyWebServiceImpl implements MyWebService{
	
	
	@Autowired
	noticeService noticeService;

	@Override
	public int toAdd(String title, String content, Integer uid, String spare1) {
		noticeService.toAdd(title, content, uid, spare1);
		return 0;
	}
	
	

}
