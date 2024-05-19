package com.ourhome.chat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ourhome.chat.entity.ChatRoom;
import com.ourhome.chat.entity.CreateRequestDto;

@Mapper
public interface ChatRoomDao {

	 @Select("SELECT r.id AS id, r.home_id As homeId, h.name AS name "
	 		+ "FROM chat_room r "
	 		+ "JOIN entered_chat_room er "
	 		+ "ON r.id = er.chat_room_id "
	 		+ "JOIN home h "
	 		+ "ON r.home_id = h.id "
	 		+ "WHERE er.user_id = #{userId}")
	 List<ChatRoom> selectEnteredChatRoomByUserId(long userId);

	// @Select("SELECT * "
	// 		+ "FROM message"
	// 		+ "WHERE room_id = #{roomId}")
	// List<Message> selectMessageByRoomId(long roomId);

	@Insert("INSERT INTO chat_room (home_id, name) VALUE (#{homeId}, #{name})")
	void save(CreateRequestDto requestDto);

	@Delete("DELETE FROM chat_room WHERE id = #{id}")
	void deleteById(long id);
}
