package com.accp.dl.service;

import com.accp.domain.Noticepicture;

public interface noticepictureService {

	   /**
     * 添加一张新图片
     * @param url
     * @return
     */
    int addinsert(String url);
    
    /**
     * 查询最后一张图片
     * @return
     */
    Noticepicture selectOrderBy();
	
	
	
	
	
}
