package com.accp.hx.service;

import java.util.List;

import com.accp.domain.Social;

public interface SocialService1 {

	 int insert(Social record);
	 
	 List<Social>sidselect(Integer uid);
}
  