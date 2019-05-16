package com.accp.dl.handler;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@ServerEndpoint("/websocket")
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
	
	/**
	 * 单发
	 * @param msg
	 * @param targetId
	 * @return
	 */
//	public String sendMsg(String msg,String targetId) {
//		WebSocketSession session = map.get(targetId);
//		try {
//			System.out.println(session+"是什么？");
//			session.sendMessage(new TextMessage(msg));
//			System.out.println(msg+"是什么？");
//			return "001";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "002";
//		}
//	}
	
	/**
	 * 群发
	 * @param msg
	 * @param id
	 * @return
	 */
	public String sendMsg(String msg,String[] id) {
		 // 此处使用循环多次发送
			for (int i = 0; i < id.length;i++) {
				System.out.println(id[i]+"数据？");
				WebSocketSession session=map.get(id[i]);
				try {
					session.sendMessage(new TextMessage(msg));
					return "001";
				} catch (Exception e) {
					e.printStackTrace();
					return "002";
				}
			}
			return null;
	}
	
	
	

	   /**
	    * 收到消息时触发的回调
	    */
	   public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
	
	   
	   
	   }

	   /**
	    * 传输消息出错时触发的回调
	    */
	   public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
	}

	   /**
	    * 断开连接后触发的回调
	    */
	   public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
	}

	   /**
	    * 是否处理分片消息
	    */
	   public boolean supportsPartialMessages() {
		return false;
	}
	
	
}
