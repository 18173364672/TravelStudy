package com.accp.zjq.service;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.dao.OrderMapper;
import com.accp.domain.MonthOrder;
import com.accp.domain.MonthSr;

@Service
public class OrderService {
	@Autowired
	OrderMapper om;
	
	/**
	 * 查询月收入
	 * @return
	 */
	public List<MonthSr> selectMonthSr(String years){
		return om.SelectMonthSr(years);
	}
	
	
	/**
	 * 查询月订单数
	 * @param years
	 * @return
	 */
	public List<MonthOrder> SelectMonthOr(String years){
		return om.SelectMonthOr(years);
	}
	
	public List<MonthOrder> SelectOrYears(){
		return om.SelectOrYears();
	}
}
