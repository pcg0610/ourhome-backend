package com.ourhome.chat.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatController extends TextWebSocketHandler {
	
	private final Map<String, WebSocketSession> sessions = new HashMap<>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		final String sessionId = session.getId();
		final String enteredMessage = sessionId + "님이 입장하셨습니다.";
		
		sessions.put(sessionId, session);
		

		sendMessage(sessionId, new TextMessage(enteredMessage));
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		final String sessionId = session.getId();

		sendMessage(sessionId, message);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		final String sessionId = session.getId();
		final String leaveMessage = sessionId + "님이 떠났습니다.";
		sessions.remove(sessionId);
		
		sendMessage(sessionId, new TextMessage(leaveMessage));
	}
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		super.handleTransportError(session, exception);
	}
	
	private void sendMessage(String sessionId, WebSocketMessage<?> message) {
		sessions.values().forEach((s) -> {
			if (!s.getId().equals(sessionId) && s.isOpen()) {
				try {
					s.sendMessage(message);
				} catch (IOException e ) {
					throw new RuntimeException(e);
				}
			}
		});
	}
}
