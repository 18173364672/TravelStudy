package com.accp.hmf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.EmployeeMapper;
import com.accp.dao.FieldMapper;
import com.accp.dao.ProjectMapper;
import com.accp.dao.ProjectimgMapper;
import com.accp.domain.Employee;
import com.accp.domain.Field;
import com.accp.domain.Project;
import com.accp.domain.Projectimg;
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
     @Autowired
     ProjectimgMapper ptm;
	
	@Override
	public PageInfo<Project> querypage(Integer currentPage, Integer pageSize, String projectname) {
		// TODO Auto-generated method stub
		Page<Project> p = PageHelper.startPage(currentPage, pageSize,true);
		List<Project> list=pm.pquery(projectname);
		 
		 
		for (Project project : list) {
		      String []eid=project.getIds().split(",");
		      List<Employee> elist=new ArrayList<Employee>();
		      List<Field> flist=new ArrayList<Field>();
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

	@Override
	public int insertSelective(Projectimg record) {
		// TODO Auto-generated method stub
		return ptm.insertSelective(record);
	}

	@Override
	public List<Projectimg> queryimg(Integer id) {
		// TODO Auto-generated method stub
		return ptm.queryimg(id);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return pm.deleteByPrimaryKey(id);
	}

	@Override
	public int deletes(Integer id) {
		// TODO Auto-generated method stub
		return ptm.deletes(id);
	}

	@Override
	public Project queryd(Integer id) {
		// TODO Auto-generated method stub
		return pm.queryd(id);
	}

	@Override
	public List<Project> selectPorject() {
		// TODO Auto-generated method stub
		return pm.selectPorject();
	}

}
