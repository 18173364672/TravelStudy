package com.accp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@MapperScan("com.accp.dao")
@EnableCaching
@EnableWebSocket
public class TravelStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelStudyApplication.class, args);
	}

}
