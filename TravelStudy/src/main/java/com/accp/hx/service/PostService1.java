package com.accp.hx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Post;

public interface PostService1 {
	 int insert(Post record);
	 
	 List<Post> postselect(@Param("tid")Integer tid);
	 
	 Post postxxselect(@Param("id")Integer id);
	 List<Post>postgzselect(@Param("tid")Integer tid,@Param("uid")Integer uid);
}
 