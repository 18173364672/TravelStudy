package com.accp.hx.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.accp.dao.PostMapper;
import com.accp.domain.Post;
import com.accp.hx.service.PostService1;

@Service
@Transactional
public class PostServiceImpl1 implements PostService1{

	@Autowired
	PostMapper PostMapper;
	
	@Override
	public int insert(Post record) {
		// TODO Auto-generated method stub
		return PostMapper.insert(record);
	}

	@Override
	public List<Post> postselect(Integer tid) {
		// TODO Auto-generated method stub
		return PostMapper.postselect(tid);
	}

	@Override
	public Post postxxselect(Integer id) {
		// TODO Auto-generated method stub
		return PostMapper.postxxselect(id);
	}

	@Override
	public List<Post> postgzselect(Integer tid, Integer uid) {
		// TODO Auto-generated method stub
		return PostMapper.postgzselect(tid, uid);
	}

	
}
