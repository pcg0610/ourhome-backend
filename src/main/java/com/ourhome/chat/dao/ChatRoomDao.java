package com.ourhome.chat.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ourhome.chat.entity.ChatRoom;
import com.ourhome.chat.entity.CreateRequestDto;
import com.ourhome.chat.entity.EnterRequestDto;

@Mapper
public interface ChatRoomDao {
	
	@Select("SELECT * FROM chat_room WHERE post_id = #{postId} AND user_id = #{userId}")
	@Results(id = "chatRoomMap", value = {
			@Result(property = "postId", column = "post_id"),
			@Result(property = "registered_date", column = "registeredDate", javaType = Date.class)
	})
	ChatRoom selectByPostIdAndUserId(long postId, long userId);

	@Select("SELECT r.id AS id, r.post_id As postId, r.name, r.registered_date AS registeredDate "
	 		+ "FROM chat_room r "
	 		+ "JOIN entered_chat_room er "
	 		+ "ON r.id = er.chat_room_id "
	 		+ "WHERE er.user_id = #{userId}")
	@ResultMap("chatRoomMap")
	List<ChatRoom> selectEnteredChatRoomByUserId(long userId);

	// @Select("SELECT * "
	// 		+ "FROM message"
	// 		+ "WHERE room_id = #{roomId}")
	// List<Message> selectMessageByRoomId(long roomId);

	@Insert("INSERT INTO chat_room (post_id, name) VALUE (#{postId}, #{name})")
	void save(CreateRequestDto requestDto);

	@Delete("DELETE FROM chat_room WHERE id = #{id}")
	void deleteById(long id);
	
	@Insert("INSERT INTO entered_chat_room (user_id, chat_room_id) VALUE (#{userId}, #{chatRoomId})")
	boolean insertEnteredChatRoom(long chatRoomId, long userId);
}
