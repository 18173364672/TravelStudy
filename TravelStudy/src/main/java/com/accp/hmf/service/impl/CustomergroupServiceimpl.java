package com.accp.hmf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.CustomergroupMapper;
import com.accp.domain.Customergroup;
import com.accp.domain.CustomergroupExample;
import com.accp.domain.Customerss;
import com.accp.hmf.service.CustomergroupService;

@Service
@Transactional
public class CustomergroupServiceimpl implements CustomergroupService{
    
	@Autowired
	CustomergroupMapper cgm;
	
	@Override
	public List<Customergroup> selectByExample(CustomergroupExample example) {
		// TODO Auto-generated method stub
		return cgm.selectByExample(null);
	}

	@Override
	public int groupid(String groupname) {
		// TODO Auto-generated method stub
		return cgm.groupid(groupname);
	}

	@Override
	public int updateByPrimaryKeySelective(Customergroup record) {
		// TODO Auto-generated method stub
		return cgm.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Customergroup record) {
		// TODO Auto-generated method stub
		return cgm.updateByPrimaryKey(record);
	}

	@Override
	public Customergroup groupname(Integer id) {
		// TODO Auto-generated method stub
		return cgm.groupname(id);
	}

	

}
