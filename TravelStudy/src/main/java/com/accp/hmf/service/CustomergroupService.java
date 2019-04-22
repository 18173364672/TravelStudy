package com.accp.hmf.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Customergroup;
import com.accp.domain.CustomergroupExample;

public interface CustomergroupService {
   
	List<Customergroup> selectByExample(CustomergroupExample example);
	
	 int groupid(@Param("groupname") String groupname);
}
