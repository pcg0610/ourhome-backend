package com.ourhome.chat.entity;

public class RoomDto {
	
	private long roomId;

	private String homeName;

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	
	public String getHomeName() {
		return homeName;
	}
	
	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}
	
}
