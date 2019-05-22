package com.accp.qyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.EventitemsMapper;
import com.accp.domain.Eventitems;
import com.accp.qyj.service.EventitemsService;

@Service
@Transactional
public class EventitemsServiceImpl implements EventitemsService{
	
	@Autowired
	EventitemsMapper m;
	@Override
	public List<Eventitems> eveselect(Integer id) {
		// TODO Auto-generated method stub
		return m.eveselect(id);
	}

}
