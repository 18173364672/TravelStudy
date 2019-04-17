package com.accp.hmf.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Field;
import com.accp.domain.Fieldtype;
import com.accp.domain.FieldtypeExample;
import com.github.pagehelper.PageInfo;

public interface FieldService {
    
	//场地分页
	 public PageInfo<Field> querypage(Integer currentPage,Integer pageSize,String name);
	 
	 //查询场地类型信息
	 Fieldtype queryfname(Integer id);
	 
	 //新增场地类型
	 int insertSelective(Fieldtype record);
	 
	 //新增场地
	 int insertSelective(Field record);
	 
	 //更新场地信息
	 int updateByPrimaryKeySelective(Field record);
	 
	 //删除场地
	 int deleteByPrimaryKey(Integer id);
	 
	 //查询单个场地信息
	 Field fqueryd(Integer id);
	 
	 //查询场地名
	 String fqueryname(Integer id);
	 
	 //查询场地
	 List<Field> fquery(@Param("name") String name);
	 
	 //查询场地类型
	 List<Fieldtype> selectByExample(FieldtypeExample example);
	
	
}
