package com.accp.dao;

import java.util.List;

import com.accp.domain.Organizationzw;

public interface OrganizationzwMapper {
    
	public int insertSelective(Organizationzw organizationzw);
	
	List<Organizationzw> queryzw(Integer id);
	
	int deletezw(Integer id);
}
