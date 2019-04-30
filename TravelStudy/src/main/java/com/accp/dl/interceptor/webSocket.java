package com.accp.dl.interceptor;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import com.accp.domain.Notice;

public class webSocket implements HandshakeInterceptor{

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		/**
//		 * 匹配用户(获取http:session中的用户),将用户存储在ws:session中
//		 */
		ServletServerHttpRequest servletRequest = (ServletServerHttpRequest)request;
		//从http:request中获取session中的用户对象
		Notice zsgc = (Notice)servletRequest.getServletRequest().getSession().getAttribute("");
		if (zsgc!=null) {
			attributes.put("id", zsgc.getId());
			return true;
		}
		
		return false;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		// TODO Auto-generated method stub
		
	}

}
