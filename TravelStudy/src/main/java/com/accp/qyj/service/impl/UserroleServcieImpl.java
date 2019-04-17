package com.accp.qyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.UserroleMapper;
import com.accp.domain.Userrole;
import com.accp.domain.UserroleExample;
import com.accp.qyj.service.UserroleService;

@Service
@Transactional
public class UserroleServcieImpl implements UserroleService{

	@Autowired
	UserroleMapper m;
	
	@Override
	public int countByExample(UserroleExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(UserroleExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return m.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Userrole record) {
		// TODO Auto-generated method stub
		return m.insert(record);
	}

	@Override
	public int insertSelective(Userrole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Userrole> selectByExample(UserroleExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Userrole selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(Userrole record, UserroleExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Userrole record, UserroleExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Userrole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Userrole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return m.delete(id);
	}

}
