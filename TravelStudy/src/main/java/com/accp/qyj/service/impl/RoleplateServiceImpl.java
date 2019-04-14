package com.accp.qyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.RoleplateMapper;
import com.accp.domain.Roleplate;
import com.accp.domain.RoleplateExample;
import com.accp.qyj.service.RoleplateService;

@Service
@Transactional
public class RoleplateServiceImpl implements RoleplateService{
	
	@Autowired
	RoleplateMapper m;

	@Override
	public int countByExample(RoleplateExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(RoleplateExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Roleplate record) {
		// TODO Auto-generated method stub
		return m.insert(record);
	}

	@Override
	public int insertSelective(Roleplate record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Roleplate> selectByExample(RoleplateExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Roleplate selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return m.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(Roleplate record, RoleplateExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Roleplate record, RoleplateExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Roleplate record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Roleplate record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Roleplate> querybyid(Integer rid) {
		// TODO Auto-generated method stub
		return m.querybyid(rid);
	}

	@Override
	public int deleteByRid(Integer rid) {
		// TODO Auto-generated method stub
		return m.deleteByRid(rid);
	}

}
