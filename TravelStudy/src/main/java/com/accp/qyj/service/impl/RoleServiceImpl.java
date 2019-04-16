package com.accp.qyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.RoleMapper;
import com.accp.domain.Role;
import com.accp.domain.RoleExample;
import com.accp.qyj.service.RoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleMapper m;
	
	@Override
	public int countByExample(RoleExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(RoleExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer rid) {
		// TODO Auto-generated method stub
		return m.deleteByPrimaryKey(rid);
	}

	@Override
	public int insert(Role record) {
		// TODO Auto-generated method stub
		return m.insert(record);
	}

	@Override
	public int insertSelective(Role record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Role> selectByExample(RoleExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role selectByPrimaryKey(Integer rid) {
		// TODO Auto-generated method stub
		return m.selectByPrimaryKey(rid);
	}

	@Override
	public int updateByExampleSelective(Role record, RoleExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Role record, RoleExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		// TODO Auto-generated method stub
		return m.updateByPrimaryKey(record);
	}

	@Override
	public List<Role> queryAll(String name) {
		// TODO Auto-generated method stub
		return m.queryAll(name);
	}

	@Override
	public int deleteAll(Integer[] rid) {
		// TODO Auto-generated method stub
		return m.deleteAll(rid);
	}

	@Override
	public PageInfo<Role> queryByPage(Integer currentPage, Integer pageSize, String name) {
		// TODO Auto-generated method stub
		Page<Role> page = PageHelper.startPage(currentPage, pageSize, true);
		m.queryAll(name);
		
		return page.toPageInfo();
	}

	@Override
	public List<Role> queryName(Integer rid) {
		// TODO Auto-generated method stub
		return m.queryName(rid);
	}

}
