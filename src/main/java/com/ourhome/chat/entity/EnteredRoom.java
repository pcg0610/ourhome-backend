package com.ourhome.chat.entity;

public class EnteredRoom {

	private long id;
	
	private long userId;
	
	private long roomId;
	
	private RoomStatus roomStatus = RoomStatus.ENTER;
	
	public EnteredRoom(long userId, long roomId) {
		this.userId = userId;
		this.roomId = roomId;
	}
}
