package com.accp.hx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Post;

public interface PostService {
	 int insert(Post record);
	 
	 List<Post> postselect(@Param("tid")Integer tid);
	 
	 Post postxxselect(@Param("id")Integer id);
}
