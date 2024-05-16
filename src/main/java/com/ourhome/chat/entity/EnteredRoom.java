package com.ourhome.chat.entity;

import java.util.Date;

public class EnteredRoom {
	private long userId;
	
	private long roomId;
	
	private Date registeredDate;
	
	public EnteredRoom(long userId, long roomId) {
		this.userId = userId;
		this.roomId = roomId;
	}
}
