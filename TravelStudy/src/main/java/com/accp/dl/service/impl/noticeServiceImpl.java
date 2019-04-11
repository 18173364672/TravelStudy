package com.accp.dl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.NoticeMapper;
import com.accp.dl.service.noticeService;
import com.accp.domain.Notice;

@Service
@Transactional			//加了事物处理就会数据加不进去
public class noticeServiceImpl implements noticeService{
	
	@Autowired
	NoticeMapper notices;

	/**
	 * 群发公司所有员工
	 */
	@Override
	public int add(String title,String content,Integer uid) {
//		System.out.println("service层的内容:"+notice.getContent());
		return notices.add(title,content,uid);
	}

	 /**
     * 查询最后的数据
     * @return
     */
	@Override
	public Notice selectOrderBy() {
		return notices.selectOrderBy();
	}
	

	
}
