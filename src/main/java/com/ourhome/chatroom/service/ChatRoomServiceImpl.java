package com.ourhome.chatroom.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ourhome.chatroom.dao.ChatRoomDao;
import com.ourhome.chatroom.entity.ChatRoom;
import com.ourhome.chatroom.entity.CreateRequestDto;
import com.ourhome.chatroom.entity.EnterRequestDto;

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

	@Override
	@Transactional
	public boolean enter(EnterRequestDto enterRequestDto) {
		ChatRoom chatRoom = chatRoomDao.selectByPostIdAndUserId(enterRequestDto.getPostId(), enterRequestDto.getPostAuthorId());
		
		return chatRoomDao.insertEnteredChatRoom(chatRoom.getId(), enterRequestDto.getUserId());
	}

	@Override
	public long getPostId(long userId, long homeId) {
		return chatRoomDao.getPostId(userId, homeId);
	}
}
