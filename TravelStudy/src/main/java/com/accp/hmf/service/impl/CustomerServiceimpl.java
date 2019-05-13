package com.accp.hmf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.CustomergroupMapper;
import com.accp.dao.CustomerssMapper;
import com.accp.domain.Customergroup;
import com.accp.domain.Customerss;
import com.accp.domain.Employee;
import com.accp.hmf.service.CustomerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class CustomerServiceimpl implements CustomerService{
    
	@Autowired
	CustomerssMapper cm;
	@Autowired
	CustomergroupMapper cgm;
	
	@Override
	public PageInfo<Customerss> querypage(Integer currentPage, Integer pageSize, String createtime, String username) {
		// TODO Auto-generated method stub
		Page<Customerss> p = PageHelper.startPage(currentPage, pageSize,true);
		List<Customerss> list=cm.cupquery(createtime, username);
		for (Customerss customerss : list) {
			if(customerss.getGroupid()>0) {
				Customergroup customergroup=cgm.groupname(customerss.getGroupid());
				customerss.setGroupname(customergroup.getGroupname());
			}else {
				customerss.setGroupname("无");
			}
	
		}
		
		return p.toPageInfo();
	}

	@Override
	public Customergroup groupname(Integer id) {
		// TODO Auto-generated method stub
		return cgm.groupname(id);
	}

	@Override
	public int insertSelective(Customerss record) {
		// TODO Auto-generated method stub
		return cm.insertSelective(record);
	}

	@Override
	public Customerss cuqueryd(Integer id) {
		// TODO Auto-generated method stub
		return cm.cuqueryd(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Customerss record) {
		// TODO Auto-generated method stub
		return cm.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Customerss> dcs(Integer id) {
		// TODO Auto-generated method stub
		return cm.dcs(id);
	}

	@Override
	public List<Customerss> dcall() {
		// TODO Auto-generated method stub
		return cm.dcall();
	}

	@Override
	public PageInfo<Customerss> querypages(Integer currentPage, Integer pageSize, String createtime, String username) {
		// TODO Auto-generated method stub
		Page<Customerss> p = PageHelper.startPage(currentPage, pageSize,true);
		List<Customerss> list=cm.cupquerys(createtime, username);
		for (Customerss customerss : list) {
			if(customerss.getGroupid()>0) {
				Customergroup customergroup=cgm.groupname(customerss.getGroupid());
				customerss.setGroupname(customergroup.getGroupname());
			}else {
				customerss.setGroupname("无");
			}
	
		}
		
		return p.toPageInfo();
		
		
		
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return cm.deleteByPrimaryKey(id);
	}

	@Override
	public Customerss cuqueryusername(String username) {
		// TODO Auto-generated method stub
		return cm.cuqueryusername(username);
	}

	@Override
	public int delbygroupid(Integer id) {
		// TODO Auto-generated method stub
		return cm.delbygroupid(id);
	}

	@Override
	public List<Customerss> querybygroupid(Integer id) {
		// TODO Auto-generated method stub
		return cm.querybygroupid(id);
	}

	@Override
	public PageInfo<Customerss> grquerypage(Integer currentPage, Integer pageSize,Integer id) {
		// TODO Auto-generated method stub
		Page<Customerss> p = PageHelper.startPage(currentPage, pageSize,true);
		List<Customerss> list=cm.querybygroupid(id);
		
		
		return p.toPageInfo();
	}

	@Override
	public List<Customerss> cupquery() {
		// TODO Auto-generated method stub
		return cm.cupquery();
	}



}
