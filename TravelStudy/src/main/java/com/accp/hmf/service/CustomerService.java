package com.accp.hmf.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Customergroup;
import com.accp.domain.Customerss;
import com.accp.domain.Employee;
import com.github.pagehelper.PageInfo;

public interface CustomerService {
     
	 public PageInfo<Customerss> querypage(Integer currentPage,Integer pageSize,String createtime,String username);
	 
	 Customergroup groupname(Integer id);
	
	 int insertSelective(Customerss record);
	 
	 Customerss cuqueryd(Integer id);
	 
	 int updateByPrimaryKeySelective(Customerss record);
	 
	 List<Customerss> dcs(Integer id);
	 
	 List<Customerss> dcall();
	 
	 int deleteByPrimaryKey(Integer id);
	 
	 Customerss cuqueryusername(@Param("username") String username);
	 
	 public PageInfo<Customerss> querypages(Integer currentPage,Integer pageSize,String createtime,String username);

	 int delbygroupid(Integer id);
	 
	 List<Customerss> querybygroupid(Integer id);
	 
	 List<Customerss> cupquery();
	 
	 public PageInfo<Customerss> grquerypage(Integer currentPage,Integer pageSize,Integer id);
}
