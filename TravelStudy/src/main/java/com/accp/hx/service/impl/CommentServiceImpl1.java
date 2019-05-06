package com.accp.hx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.dao.CommentMapper;
import com.accp.domain.Comment;
import com.accp.hx.service.CommentService1;

@Service
public class CommentServiceImpl1 implements CommentService1{

	@Autowired
	CommentMapper CommentMapper;
	
	@Override
	public int insert(Comment record) {
		// TODO Auto-generated method stub
		return CommentMapper.insert(record);
	}

	
}
