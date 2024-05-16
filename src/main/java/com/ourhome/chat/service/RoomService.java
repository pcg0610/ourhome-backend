package com.ourhome.chat.service;

import java.util.List;

import com.ourhome.chat.entity.EnteredRoom;
import com.ourhome.chat.entity.RoomDto;

public interface RoomService {
	List<RoomDto> findAllByUserId(long userId);
}
