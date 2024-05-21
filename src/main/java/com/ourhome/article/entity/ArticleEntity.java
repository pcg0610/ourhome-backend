package com.ourhome.article.entity;

import java.util.Date;

public class ArticleEntity {
	private String userId;
	private int homeId;
	private String title;
	private String content;
	private Date registeredDate;
	
	public ArticleEntity() {
		
	}
	
	public ArticleEntity(String userId, int homeId, String title, String content, Date registeredDate) {
		this.userId = userId;
		this.homeId = homeId;
		this.title = title;
		this.content = content;
		this.registeredDate = registeredDate;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getHomeId() {
		return homeId;
	}
	public void setHomeId(int homeId) {
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
