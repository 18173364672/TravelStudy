package com.accp.hx.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.CustomerssMapper;
import com.accp.domain.Customerss;
import com.accp.hx.service.CustomerssService;

@Service
@Transactional
public class CustomerssServiceimpl implements CustomerssService {

	@Autowired
	CustomerssMapper customerssmapper;
	
	@Override
	public Customerss dl(String Username, String UserPassWord) {
		// TODO Auto-generated method stub
		return customerssmapper.dl(Username, UserPassWord);
	}

	
	
	
	
}
