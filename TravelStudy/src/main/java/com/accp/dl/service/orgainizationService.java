package com.accp.dl.service;

import java.util.List;

import com.accp.domain.Organization;
import com.accp.domain.OrganizationExample;

public interface orgainizationService {

    List<Organization> selectByExample(OrganizationExample example);
	
    /**
     * 根据员工的部门id查询数据
     * @param id
     * @return
     */
    Organization selectById(Integer id);
    
	
}
