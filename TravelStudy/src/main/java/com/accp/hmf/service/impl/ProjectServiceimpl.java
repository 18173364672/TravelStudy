package com.accp.hmf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.EmployeeMapper;
import com.accp.dao.FieldMapper;
import com.accp.dao.ProjectMapper;
import com.accp.domain.Employee;
import com.accp.domain.Field;
import com.accp.domain.Project;

import com.accp.hmf.service.ProjectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class ProjectServiceimpl implements ProjectService{
     @Autowired
     ProjectMapper pm;
     @Autowired
     EmployeeMapper em;
     @Autowired
     FieldMapper fm;
	
	@Override
	public PageInfo<Project> querypage(Integer currentPage, Integer pageSize, String projectname) {
		// TODO Auto-generated method stub
		Page<Project> p = PageHelper.startPage(currentPage, pageSize,true);
		List<Project> list=pm.pquery(projectname);
		 List<Employee> elist=new ArrayList<Employee>();
		 List<Field> flist=new ArrayList<Field>();
		for (Project project : list) {
		      String []eid=project.getIds().split(",");
		      for (String eids : eid) {
				 Employee employee=em.emqueryd(Integer.parseInt(eids));
				
				 elist.add(employee);
				 
			}
		      project.setEmlist(elist);
		    
		      String []fid=project.getIds1().split(",");
		      for (String fids : fid) {
				Field field=fm.fqueryd(Integer.parseInt(fids));
			
				
				flist.add(field);
			}
			
			project.setFlist(flist);
		}
		
		
		
		
		return p.toPageInfo();
	}

	@Override
	public int insertSelective(Project record) {
		// TODO Auto-generated method stub
		return pm.insertSelective(record);
	}

}