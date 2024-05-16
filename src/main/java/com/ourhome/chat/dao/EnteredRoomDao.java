package com.ourhome.chat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ourhome.chat.entity.EnteredRoom;

@Mapper
public interface EnteredRoomDao {
	
	List<EnteredRoom> findAllByUserId(long userId);
}
