package com.accp.hx.service;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Customerss;

public interface CustomerssService {

	Customerss dl(@Param("Username")String Username,@Param("UserPassWord")String UserPassWord);
}
