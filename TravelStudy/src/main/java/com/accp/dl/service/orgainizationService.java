package com.accp.dl.service;

import java.util.List;

import com.accp.domain.Organization;
import com.accp.domain.OrganizationExample;

public interface orgainizationService {

    List<Organization> selectByExample(OrganizationExample example);
	
	
	
}
