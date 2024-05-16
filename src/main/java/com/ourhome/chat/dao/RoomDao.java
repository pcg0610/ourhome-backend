package com.ourhome.chat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ourhome.chat.entity.RoomDto;

@Mapper
public interface RoomDao {
	
	@Select("SELECT r.id AS roomId, h.name AS homeName AS createdDate "
			+ "FROM room r "
			+ "JOIN entered_room er "
			+ "ON r.id = er.room_id "
			+ "JOIN home h "
			+ "ON r.home_id = h.id"
			+ "WHERE er.user_id=${userId}")
	List<RoomDto> findAllByUserId(long userId);
}
