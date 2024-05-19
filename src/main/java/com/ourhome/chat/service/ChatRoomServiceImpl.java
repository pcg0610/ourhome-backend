package com.ourhome.chat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ourhome.chat.dao.ChatRoomDao;
import com.ourhome.chat.entity.ChatRoom;
import com.ourhome.chat.entity.CreateRequestDto;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

	private final ChatRoomDao chatRoomDao;

	ChatRoomServiceImpl(ChatRoomDao chatRoomDao) {
		this.chatRoomDao = chatRoomDao;
	}

	@Override
	public void save(CreateRequestDto requestDto) {
		chatRoomDao.save(requestDto);
	}

	@Override
	public List<ChatRoom> getEnteredList(long userId) {
		return chatRoomDao.selectEnteredChatRoomByUserId(userId);
	}

	// @Override
	// public List<Message> getMessageList(long roomId) {
	// 	return chatRoomDao.selectMessageByRoomId(roomId);
	// }
}
