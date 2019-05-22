package com.accp.hx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.CollectMapper;
import com.accp.domain.Collect;
import com.accp.hx.service.CollectService1;

@Service
@Transactional
public class CollectServiceImpl implements CollectService1{
     
	@Autowired 
	CollectMapper CollectMapper;
	 
	@Override
	public int insert(Collect record) {
		// TODO Auto-generated method stub
		return CollectMapper.insert(record);
	}

}
