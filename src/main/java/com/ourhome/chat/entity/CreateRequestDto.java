package com.ourhome.chat.entity;

public class CreateRequestDto {
	private long postId;
	
	private String name;

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CreateRequestDto [postId=" + postId + ", name=" + name + "]";
	}

}
