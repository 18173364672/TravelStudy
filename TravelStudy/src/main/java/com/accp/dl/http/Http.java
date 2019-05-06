package com.accp.dl.http;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Http {

	
public static void main(String[] args) {
		
//		CloseableHttpClient client = HttpClients.createDefault();
//		HttpPost post = new HttpPost("ws://localhost:8080/WebSocketServer/ws/张三");
//		try {
//			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
//			
//			BasicNameValuePair id = new BasicNameValuePair("id", null);
//			parameters.add(id);
//			HttpEntity entity = new UrlEncodedFormEntity(parameters);
//			post.setEntity(entity);
//			CloseableHttpResponse response = client.execute(post);
//			String str = EntityUtils.toString(response.getEntity(),"utf-8");
//			System.out.println("哈哈哈哈哈哈:"+str);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
	}
	
	
}
