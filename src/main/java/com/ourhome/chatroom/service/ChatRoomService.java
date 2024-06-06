package com.ourhome.chatroom.service;

import java.util.List;

import com.ourhome.chatroom.entity.ChatRoom;
import com.ourhome.chatroom.entity.CreateRequestDto;
import com.ourhome.chatroom.entity.EnterRequestDto;

public interface ChatRoomService {
	List<ChatRoom> getEnteredList(long userId);

	void save(CreateRequestDto chatRoom);
	
	boolean enter(EnterRequestDto enterRequestDto);
	
	long getPostId(long userId, long homeId);
}
