package com.example.demo3.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat/room")
public class ChatServer {
	
	private static List<Session> sessionList = new ArrayList<>();
	
	@OnOpen
	public void onOpen(Session session) {
		sessionList.add(session);
		System.out.println("Session " + session.getId() + " opened");
//		System.out.println("sessionList.size() = " + sessionList.size());
//		System.out.println("sessionList = " + sessionList);
//		System.out.println("this = " + this);
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		System.out.println("Session " + session.getId() + " send message: '" + message +"'");
		
		sessionList.stream()
			.forEach(s -> {
				try {
					System.out.println("Send message: '" + message +"' to " + s.getId());
					s.getBasicRemote()
						.sendText(message);
				} catch(IOException ex) {
					ex.printStackTrace();
				}
			});
	}
	
	@OnClose
	public void onClose(Session session) {
		sessionList.remove(session);
		System.out.println("Session " + session.getId() + " closed");
	}

}
