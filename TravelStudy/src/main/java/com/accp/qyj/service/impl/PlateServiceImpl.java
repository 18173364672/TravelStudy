package com.accp.qyj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.PlateMapper;
import com.accp.domain.Plate;
import com.accp.domain.PlateExample;
import com.accp.qyj.service.PlateService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class PlateServiceImpl implements PlateService{

	@Autowired
	PlateMapper m;
	
	
	@Override
	public int countByExample(PlateExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(PlateExample example) {
		// TODO Auto-generated method stub
		return m.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer pid) {
		// TODO Auto-generated method stub
		return m.deleteByPrimaryKey(pid);
	}

	@Override
	public int insert(Plate record) {
		// TODO Auto-generated method stub
		return m.insert(record);
	}

	@Override
	public int insertSelective(Plate record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Plate> selectByExample(PlateExample example) {
		// TODO Auto-generated method stub
		return m.selectByExample(example);
	}

	@Override
	public Plate selectByPrimaryKey(Integer pid) {
		// TODO Auto-generated method stub
		return m.selectByPrimaryKey(pid);
	}

	@Override
	public int updateByExampleSelective(Plate record, PlateExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Plate record, PlateExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Plate record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Plate record) {
		// TODO Auto-generated method stub
		return m.updateByPrimaryKey(record);
	}

	@Override
	public List<Plate> queryAll(String name) {
		// TODO Auto-generated method stub
		return m.queryAll(name);
	}


	@Override
	public int deleteAll(Integer[] pid) {
		// TODO Auto-generated method stub
		return m.deleteAll(pid);
	}

	@Override
	public PageInfo<Plate> queryByPage(Integer currentPage, Integer pageSize , String name) {
		// TODO Auto-generated method stub
		Page<Plate> page = PageHelper.startPage(currentPage, pageSize, true);
		m.queryAll(name);
		return page.toPageInfo();
	}

	@Override
	public List<Plate> queryPlate(Integer rid) {
		// TODO Auto-generated method stub
		return m.queryPlate(rid);
	}

	@Override
	public Map<String, Plate> queryPlateByUserId(Integer uid){
		System.out.println("进来了");
		return m.queryPlateByUserId(uid);
	}

}
