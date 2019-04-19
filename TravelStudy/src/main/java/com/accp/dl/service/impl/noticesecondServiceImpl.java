package com.accp.dl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.NoticesecondMapper;
import com.accp.dl.service.noticesecondService;
import com.accp.domain.Noticesecond;


@Service
@Transactional
public class noticesecondServiceImpl implements noticesecondService{

	@Autowired
	NoticesecondMapper noticesecond;
	
	@Override
	public int addNoticesecound(Integer rid, Integer iid, Integer nid) {
		return noticesecond.addNoticesecound(rid, iid, nid);
	}

	@Override
	public Noticesecond selectById(Integer nid) {
		return noticesecond.selectById(nid);
	}

}
