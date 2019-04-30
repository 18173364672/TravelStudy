package com.accp.dl.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class webSocketHandler extends TextWebSocketHandler{

	
	/**
	 * 存储所有握手成功的用户
	 */
	Map<String, WebSocketSession> map = new HashMap<String,WebSocketSession>();
	//建立连接后
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//存储握手成功用户
		String id = session.getAttributes().get("id")+"";
		map.put(id, session);
		session.sendMessage(new TextMessage("建立连接成功,可以进行通信!"));
	}
	
	public String sendMsg(String msg,String targetId) {
		WebSocketSession session = map.get(targetId);
		try {
			session.sendMessage(new TextMessage(msg));
			return "001";
		} catch (Exception e) {
			e.printStackTrace();
			return "002";
		}
	}
	
	
	
	
}
