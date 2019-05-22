package com.accp.hx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.SocialMapper;
import com.accp.domain.Social;
import com.accp.hx.service.SocialService1;

@Service
@Transactional
public class SocialServiceImpl implements SocialService1 {

	@Autowired
	SocialMapper socialMapper;
  
	@Override
	public int insert(Social record) {
		// TODO Auto-generated method stub
		return socialMapper.insert(record);
	}

	@Override
	public List<Social> sidselect(Integer uid) {
		// TODO Auto-generated method stub
		return socialMapper.sidselect(uid);
	}
}
