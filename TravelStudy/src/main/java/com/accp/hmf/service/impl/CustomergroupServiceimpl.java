package com.accp.hmf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.CustomergroupMapper;
import com.accp.dao.CustomerssMapper;
import com.accp.domain.Customergroup;
import com.accp.domain.CustomergroupExample;
import com.accp.domain.Customerss;
import com.accp.hmf.service.CustomergroupService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class CustomergroupServiceimpl implements CustomergroupService{
    
	@Autowired
	CustomergroupMapper cgm;
	@Autowired
	CustomerssMapper cm;
	
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

	@Override
	public PageInfo<Customergroup> querypage(Integer currentPage, Integer pageSize,String groupname) {
		// TODO Auto-generated method stub
		Page<Customergroup> p = PageHelper.startPage(currentPage, pageSize,true);
		List<Customergroup> list=cgm.cgquerypage(groupname);
		for (Customergroup c : list) {
			if(c.getFid()>0) {
				Customerss customerss=cm.cuqueryd(c.getFid());
				c.setFzr(customerss.getUsername());
			}else {
				c.setFzr("暂无");
			}
		}
		
		return p.toPageInfo();
	}

	@Override
	public int insertSelective(Customergroup record) {
		// TODO Auto-generated method stub
		return cgm.insertSelective(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return cgm.deleteByPrimaryKey(id);
	}

	

}
