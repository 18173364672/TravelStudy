package com.accp.hmf.service;


import com.accp.domain.Field;
import com.accp.domain.Fieldtype;
import com.github.pagehelper.PageInfo;

public interface FieldService {
    
	 public PageInfo<Field> querypage(Integer currentPage,Integer pageSize,String name);
	 
	 Fieldtype queryfname(Integer id);
	 
	 int insertSelective(Fieldtype record);
	 
	 int insertSelective(Field record);
	 
	 int updateByPrimaryKeySelective(Field record);
	 
	 
	 int deleteByPrimaryKey(Integer id);
	
	
}
