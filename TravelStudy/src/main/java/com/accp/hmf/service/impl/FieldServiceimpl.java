package com.accp.hmf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.FieldMapper;
import com.accp.dao.FieldtypeMapper;
import com.accp.domain.Field;
import com.accp.domain.Fieldtype;
import com.accp.hmf.service.FieldService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class FieldServiceimpl implements FieldService{
    
	@Autowired
	FieldMapper fm;
	@Autowired
	FieldtypeMapper ftm;
	
	
	@Override
	public PageInfo<Field> querypage(Integer currentPage, Integer pageSize, String name) {
		// TODO Auto-generated method stub
		Page<Field> p = PageHelper.startPage(currentPage, pageSize,true);
		List<Field> list=fm.fquery(name);
		for (Field field : list) {
			Fieldtype fieldtype=ftm.queryfname(field.getTid());
			field.setFtname(fieldtype.getName());
		}
		
		return p.toPageInfo();
	}


	@Override
	public Fieldtype queryfname(Integer id) {
		// TODO Auto-generated method stub
		return ftm.queryfname(id);
	}


	@Override
	public int insertSelective(Fieldtype record) {
		// TODO Auto-generated method stub
		return ftm.insertSelective(record);
	}


	@Override
	public int insertSelective(Field record) {
		// TODO Auto-generated method stub
		return fm.insertSelective(record);
	}


	

	@Override
	public int updateByPrimaryKeySelective(Field record) {
		// TODO Auto-generated method stub
		return fm.updateByPrimaryKeySelective(record);
	}


	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return fm.deleteByPrimaryKey(id);
	}


	@Override
	public Field fqueryd(Integer id) {
		// TODO Auto-generated method stub
		return fm.fqueryd(id);
	}


	@Override
	public String fqueryname(Integer id) {
		// TODO Auto-generated method stub
		return fm.fqueryname(id);
	}

	

}
