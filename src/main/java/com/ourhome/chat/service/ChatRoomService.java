package com.ourhome.chat.service;

import java.util.List;

import com.ourhome.chat.entity.ChatRoom;
import com.ourhome.chat.entity.CreateRequestDto;

public interface ChatRoomService {
	 List<ChatRoom> getEnteredList(long userId);

	// List<Message> getMessageList(long roomId);

	void save(CreateRequestDto chatRoom);
}
