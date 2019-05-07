package com.accp.hx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.DynamicpictureMapper;
import com.accp.domain.Dynamicpicture;
import com.accp.hx.service.DynamicpictureService;

@Service
@Transactional
public class DynamicpictureServiceImpl implements DynamicpictureService{

	@Autowired
	DynamicpictureMapper DynamicpictureMapper;
	
	@Override
	public int insert(Dynamicpicture record) {
		// TODO Auto-generated method stub
		return DynamicpictureMapper.insert(record);
	}

}
