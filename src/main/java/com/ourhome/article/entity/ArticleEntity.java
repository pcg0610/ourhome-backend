package com.ourhome.article.entity;

import java.util.Date;

public class ArticleEntity {
	private long userId;
	private long homeId;
	private String title;
	private String content;
	private Date registeredDate;
	
	public ArticleEntity() {
		
	}

	public ArticleEntity(long userId, long homeId, String title, String content, Date registeredDate) {
		this.userId = userId;
		this.homeId = homeId;
		this.title = title;
		this.content = content;
		this.registeredDate = registeredDate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getHomeId() {
		return homeId;
	}

	public void setHomeId(long homeId) {
		this.homeId = homeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	@Override
	public String toString() {
		return "ArticleEntity [userId=" + userId + ", homeId=" + homeId + ", title=" + title + ", content=" + content
				+ ", registeredDate=" + registeredDate + "]";
	}
}
