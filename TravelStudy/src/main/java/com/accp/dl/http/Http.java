//package com.accp.dl.http;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//import javax.servlet.http.HttpSession;
//import javax.websocket.OnClose;
//import javax.websocket.OnError;
//import javax.websocket.OnMessage;
//import javax.websocket.OnOpen;
//import javax.websocket.Session;
//import javax.websocket.server.ServerEndpoint;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//
//import com.accp.dl.controller.notice;
//
//
//@ServerEndpoint("/websocket")
//public class Http {
//
//	private static int onlineCount=0;
//    private static CopyOnWriteArrayList<Http> webSocketSet=new CopyOnWriteArrayList<Http>();
//    HttpSession session;
// 
//    @OnOpen
//    public void onOpen(HttpSession session){
//        this.session=session;
//        webSocketSet.add(this);//加入set中
//        addOnlineCount();
//        System.out.println("有新连接加入！当前在线人数为"+getOnlineCount());
//    }
// 
//    @OnClose
//    public void onClose(){
//        webSocketSet.remove(this);
//        subOnlineCount();
//        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
//    }
// 
//    @OnMessage
//    public void onMessage(String message,HttpSession session){
//        System.out.println("来自客户端的消息："+message);
////        群发消息
//        for (Http item:webSocketSet){
//            try {
//                item.sendMessage(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//                continue;
//            }
//        }
//    }
// 
//    @OnError
//    public void onError(HttpSession session,Throwable throwable){
//        System.out.println("发生错误！");
//        throwable.printStackTrace();
//    }
////   下面是自定义的一些方法
//    public void sendMessage(String message) throws IOException {
//        ((Session) this.session).getBasicRemote().sendText(message);
//    }
//    
//    public static synchronized int getOnlineCount(){
//        return onlineCount;
//    }
//    public static synchronized void addOnlineCount(){
//    	Http.onlineCount++;
//    }
//    public static synchronized void subOnlineCount(){
//    	Http.onlineCount--;
//    }
//	
//	
//}
