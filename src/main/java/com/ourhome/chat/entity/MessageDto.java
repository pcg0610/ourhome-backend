package com.ourhome.chat.entity;

public class MessageDto {
	private long authorId;
	private String content;
	
	public long getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
