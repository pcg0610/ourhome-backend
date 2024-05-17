package com.ourhome.chat.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.ourhome.chat.entity.MessageDto;

@RestController
public class BrockerController {

	private final SimpMessagingTemplate template;

	BrockerController(SimpMessagingTemplate template) {
		this.template = template;
	}

	@MessageMapping("/room/{roomId}/entered")
	public void entered(@DestinationVariable(value = "roomId") String roomId, MessageDto message) {
		template.convertAndSend("/sub/room/" + roomId, message.getAuthorId() + "님이 입장하셨습니다.");
	}

	@MessageMapping("/room/{roomId}")
	public void sendMessage(@DestinationVariable(value = "roomId") String roomId, MessageDto message) {
		template.convertAndSend("/sub/room/" + roomId, message.getContent());
	}
}
