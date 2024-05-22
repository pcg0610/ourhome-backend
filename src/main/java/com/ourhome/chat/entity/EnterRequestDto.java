package com.ourhome.chat.entity;

public class EnterRequestDto {
	
	private long postId;
	
	private long userId;

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "EnterRequestDto [postId=" + postId + ", userId=" + userId + "]";
	}
	
	
}
