package com.accp.hmf.service;

import com.accp.domain.Customergroup;
import com.accp.domain.Customerss;
import com.accp.domain.Employee;
import com.github.pagehelper.PageInfo;

public interface CustomerService {

	 public PageInfo<Customerss> querypage(Integer currentPage,Integer pageSize,String createtime,String username);
	 
	 Customergroup groupname(Integer id);
	
	 int insertSelective(Customerss record);
	 
	 Customerss cuqueryd(Integer id);
}
