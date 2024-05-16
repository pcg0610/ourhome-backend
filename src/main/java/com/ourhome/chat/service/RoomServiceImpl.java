package com.ourhome.chat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ourhome.chat.dao.EnteredRoomDao;
import com.ourhome.chat.dao.RoomDao;
import com.ourhome.chat.entity.RoomDto;

@Service
public class RoomServiceImpl implements RoomService {
	
	private final RoomDao roomDao;
	
	RoomServiceImpl(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Override
	public List<RoomDto> findAllByUserId(long userId) {
		return roomDao.findAllByUserId(userId);
	}
}
