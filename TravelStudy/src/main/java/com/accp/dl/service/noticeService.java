package com.accp.dl.service;


import com.accp.domain.Notice;
import com.github.pagehelper.PageInfo;

public interface noticeService {

    /**
     * 新增公告表
     * @param notice
     * @return
     */
    int add(String title,String content,Integer uid);
	
	
    /**
     * 查询最后的数据
     * @return
     */
    Notice selectOrderBy();
    
    
    
    /**
     * 按员工发送信息
     * @param title
     * @param content
     * @param uid
     * @param spare1
     * @return
     */
    int toAdd(String title,String content,Integer uid,String spare1);
    
    
	/**
	 * 分页查询
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageInfo<Notice> selecQueryFeYue(Integer currentPage,String title,Integer pageSize);
    
}
