package com.accp.dl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.NoticeMapper;
import com.accp.dao.OrganizationMapper;
import com.accp.dl.service.orgainizationService;
import com.accp.domain.Organization;
import com.accp.domain.OrganizationExample;

@Service
@Transactional
public class orgainizationServiceImpl implements orgainizationService{

	@Autowired
	OrganizationMapper organization;
	
	
	@Override
	public List<Organization> selectByExample(OrganizationExample example) {
		return organization.selectByExample(null);
	}

}
