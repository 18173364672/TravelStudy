package com.accp.pda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.ActivityMapper;
import com.accp.dao.ProjectMapper;
import com.accp.domain.Activity;
import com.accp.domain.ActivityExample;
import com.accp.domain.Project;
import com.accp.pda.service.ActivityService;
import com.accp.pda.vo.ActivtyVo;

@Transactional
@Service
public class ActivityServiceImpl implements ActivityService{

	@Autowired
	ActivityMapper mapper;
	
	@Autowired
	ProjectMapper projectMapper;
	
	@Override
	public List<Activity> selectByExample(ActivityExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}

	@Override
	public Activity selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Activity record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Activity> selectByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectByName(name);
	}

	@Override
	public List<Project> selectPorject() {
		// TODO Auto-generated method stub
		return projectMapper.selectByExample(null);
	}

	@Override
	public ActivtyVo acvo(Integer id) {
		// TODO Auto-generated method stub
		Activity activity = mapper.selectByPrimaryKey(id);
		List<Project> list = projectMapper.queryByActId(id);
		ActivtyVo vo = new ActivtyVo();
		vo.setAct(activity);
		vo.setList(list);
		return vo;
	}

	@Override
	public int insertSelective(Activity record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	@Override
	public int insertevtime(Activity ac) {
		// TODO Auto-generated method stub
		return mapper.insertevtime(ac);
	}

	@Override
	public List<Activity> query(String name) {
		// TODO Auto-generated method stub
		return mapper.query(name);
	}


}
