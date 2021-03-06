package com.accp.hmf.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Employee;
import com.accp.domain.Project;
import com.accp.domain.Projectimg;
import com.github.pagehelper.PageInfo;

public interface ProjectService {
   
	//项目信息分页
	 public PageInfo<Project> querypage(Integer currentPage,Integer pageSize,String projectname);
     //项目新增
	 int insertSelective(Project record);
	 //项目图片新增
	 int insertSelective(Projectimg record);
	 //项目图片查看
	 List<Projectimg> queryimg(Integer id);
	 //删除项目
	 int deleteByPrimaryKey(Integer id);
	 //删除图片
	 int deletes(Integer id);
	 //查询单个项目信息
	 Project queryd(Integer id);
	 //查询所有项目
	 List<Project> selectPorject();
	 
	 List<Project> pquery(String projectname);
	 
     List<Project> queryByaid(@Param("id")Integer id);
	 
}
