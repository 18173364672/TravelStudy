package com.accp.hx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Customerss;

public interface CustomerssService1 {

	Customerss dl(@Param("Username")String Username,@Param("UserPassWord")String UserPassWord);
	List<Customerss>selectuidkhz(Integer id);
}
 