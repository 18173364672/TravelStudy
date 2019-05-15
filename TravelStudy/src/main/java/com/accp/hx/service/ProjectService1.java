package com.accp.hx.service;

import java.util.List;

import com.accp.domain.Project;
import com.accp.domain.ProjectExample;
import com.accp.domain.Userprojectdiscuss;
import com.github.pagehelper.PageInfo;

public interface ProjectService1 {

	List<Project> selectByExample(ProjectExample example);
	
	  List<Project>proxmselect();
	  
	  Project proselectid(Integer id);
	  List<Project>proquery();
	  
	  //评论数
	    int querycounthmf(Integer id);
	    
	    //好评数量
	    int queryhphmf(Integer id);
	    
	    //差评数量
	    int querycphmf(Integer id);
	    
	    //查询评论
	    List<Userprojectdiscuss> queryplhmf(Integer id);
	    
	    //评论分页
	    public PageInfo<Userprojectdiscuss> querypage(Integer currentPage,Integer pageSize,Integer id);
	
}
