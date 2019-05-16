package com.accp.config;

import java.io.File;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.accp.dl.handler.webSocketHandler;
import com.accp.dl.interceptor.webSocket;

@Configuration
public class WebSocketConfig implements WebSocketConfigurer{

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		registry.addHandler(new webSocketHandler(), "/mywebsocket")
		.setAllowedOrigins("*")
		.addInterceptors(new webSocket());
		
	}
	
	 @Bean
	 public ServerEndpointExporter serverEndpointExporter() {
	        return new ServerEndpointExporter();
	 }
	
	@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(102400000);
        factory.setMaxRequestSize(102400000);
        String location = System.getProperty("user.dir") + "/data/tmp";
        File tmpFile = new File(location);
        if (!tmpFile.exists()) {
            tmpFile.mkdirs();
        }
        factory.setLocation(location);
        return factory.createMultipartConfig();
    }

}
