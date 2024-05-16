package com.ourhome.chat.service;

import java.util.List;

import com.ourhome.chat.entity.EnteredRoom;

public interface RoomService {
	List<EnteredRoom> findAll();
}
