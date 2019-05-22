package com.accp.hx.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.CustomerssMapper;
import com.accp.domain.Customerss;
import com.accp.hx.service.CustomerssService1;

@Service
@Transactional
public class CustomerssServiceimpl1 implements CustomerssService1 {

	@Autowired
	CustomerssMapper customerssmapper;
	
	@Override
	public Customerss dl(String Username, String UserPassWord) {
		// TODO Auto-generated method stub
		return customerssmapper.dl(Username, UserPassWord);
	}

	@Override
	public List<Customerss> selectuidkhz(Integer id) {
		// TODO Auto-generated method stub
		return customerssmapper.selectuidkhz(id);
	}

	
	
	
	
}
