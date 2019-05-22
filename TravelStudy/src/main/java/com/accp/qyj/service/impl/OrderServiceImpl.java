package com.accp.qyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.OrderMapper;
import com.accp.domain.Order;
import com.accp.domain.OrderExample;
import com.accp.domain.ResultMapOrderDetail;
import com.accp.qyj.service.OrderService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderMapper m;

	@Override
	public int countByExample(OrderExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(OrderExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return m.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Order record) {
		// TODO Auto-generated method stub
		return m.insert(record);
	}

	@Override
	public int insertSelective(Order record) {
		// TODO Auto-generated method stub
		return m.insertSelective(record);
	}

	@Override
	public List<Order> selectByExample(OrderExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(Order record, OrderExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Order record, OrderExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Order record) {
		// TODO Auto-generated method stub
		return m.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Order record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Order> queryAll(String name) {
		// TODO Auto-generated method stub
		return m.queryAll(name);
	}

	@Override
	public PageInfo<Order> queryByPage(String name, Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		Page<Order> page = PageHelper.startPage(currentPage, 5, true);
		m.queryAll(name);
		
		return page.toPageInfo();
	}

	@Override
	public List<ResultMapOrderDetail> queryOrderDetail(Integer oid) {
		// TODO Auto-generated method stub
		return m.queryOrderDetail(oid);
	}

	
	@Override
	public int deleteOrderDetail(Integer id) {
		// TODO Auto-generated method stub
		return m.deleteOrderDetail(id);
	}
	
}
