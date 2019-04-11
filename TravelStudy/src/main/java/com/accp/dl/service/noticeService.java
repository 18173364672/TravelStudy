package com.accp.dl.service;

import com.accp.domain.Notice;

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
}
