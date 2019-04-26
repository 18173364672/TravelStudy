package com.accp.hmf.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Customergroup;
import com.accp.domain.CustomergroupExample;
import com.accp.domain.Customerss;
import com.github.pagehelper.PageInfo;

public interface CustomergroupService {
   
	List<Customergroup> selectByExample(CustomergroupExample example);
	
	 int groupid(@Param("groupname") String groupname);
	 
	 int updateByPrimaryKeySelective(Customergroup record);
	 
	 int updateByPrimaryKey(Customergroup record);
	 
	 Customergroup groupname(Integer id);
	 
	 int insertSelective(Customergroup record);
	 
	 public PageInfo<Customergroup> querypage(Integer currentPage, Integer pageSize,String groupname);
}
