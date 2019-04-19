package com.accp.dl.service;

import com.accp.domain.Noticesecond;

public interface noticesecondService {

	
    /**
     * 新增部门发送公告
     * @param rid
     * @param iid
     * @param nid
     * @return
     */
    int addNoticesecound(Integer rid,Integer iid,Integer nid);
    
    
    /**
     * 根据公告id查询数据
     * @param nid
     * @return
     */
    Noticesecond selectById(Integer nid);
	
    
    /**
     * 只新增公告表外键
     * @param nid
     * @return
     */
    int toAdd(Integer nid);
    
	
}
