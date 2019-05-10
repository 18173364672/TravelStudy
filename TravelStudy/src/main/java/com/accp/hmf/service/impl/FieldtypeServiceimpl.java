package com.accp.hmf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.FieldtypeMapper;
import com.accp.hmf.service.FieldtypeService;

@Service
@Transactional
public class FieldtypeServiceimpl implements FieldtypeService{
	@Autowired
	FieldtypeMapper fm;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return fm.deleteByPrimaryKey(id);
	}

}
