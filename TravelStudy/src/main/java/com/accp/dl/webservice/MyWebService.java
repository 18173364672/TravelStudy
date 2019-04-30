package com.accp.dl.webservice;

import javax.jws.WebService;
//import javax.websocket.server.ServerEndpoint;

@WebService(targetNamespace="http://webservice.accp.com")
//@ServerEndpoint("/ws/{user}")
public interface MyWebService {
	
	   /**
     * 按员工发送信息
     * @param title
     * @param content
     * @param uid
     * @param spare1
     * @return
     */
    int toAdd(String title,String content,Integer uid,String spare1);
    
    
    
    
    

}
