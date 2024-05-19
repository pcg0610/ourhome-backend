package com.ourhome.chat.entity;

import java.util.Date;

public class EnteredChatRoom {
	private long userId;

	private long roomId;

	private Date registeredDate;

	public EnteredChatRoom(long userId, long roomId) {
		this.userId = userId;
		this.roomId = roomId;
	}
}
