package com.accp.dl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.NoticepictureMapper;
import com.accp.dl.service.noticepictureService;
import com.accp.domain.Noticepicture;

@Service
@Transactional	
public class noticepictureServiceImpl implements noticepictureService{

	
	@Autowired
	NoticepictureMapper noticepicture;

	@Override
	public int addinsert(String url) {
		return noticepicture.addinsert(url);
	}

	@Override
	public Noticepicture selectOrderBy() {
		return noticepicture.selectOrderBy();
	}

	@Override
	public Noticepicture selectById(Integer id) {
		return noticepicture.selectById(id);
	}
	
	
}
