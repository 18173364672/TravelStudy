package com.accp.dl.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.NoticeMapper;
import com.accp.dl.service.noticeService;
import com.accp.domain.Notice;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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

	/**
     * 按员工发送信息
     * @param title
     * @param content
     * @param uid
     * @param spare1
     * @return
     */
	@Override
	public int toAdd(String title, String content, Integer uid, String spare1) {
		return notices.toAdd(title, content, uid, spare1);
	}

	/**
	 * 分页查询
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageInfo<Notice> selecQueryFeYue(Integer currentPage, String title, Integer pageSize) {
		Page<Notice> pageInfo = PageHelper.startPage(currentPage,pageSize,true);
		
		notices.selecQueryFeYue(title);
		
		return pageInfo.toPageInfo();
	}

	@Override
	public Notice selectById(Integer id) {
		return notices.selectById(id);
	}

	@Override
	public Notice queryAll() {
		return notices.queryAll();
	}

	/**
	 * 分页查询
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageInfo<Notice> Myquery(Integer currentPage, String title, Integer pageSize,String spare1) {
		Page<Notice> pageInfo = PageHelper.startPage(currentPage,pageSize,true);
		
		notices.Myquery(title,spare1);
		
		return pageInfo.toPageInfo();
	}

	
}
