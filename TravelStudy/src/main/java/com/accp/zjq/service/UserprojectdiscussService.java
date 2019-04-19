package com.accp.zjq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.dao.UserprojectdiscussMapper;
import com.accp.domain.MydAndName;

@Service
public class UserprojectdiscussService {
		
		@Autowired
		UserprojectdiscussMapper um;
		
		
		public List<MydAndName> selectByMyd() {
			return um.selectByMyd();
		}
		
		public List<MydAndName> selectByCp(){
			return um.selectByCp();
		}
}
