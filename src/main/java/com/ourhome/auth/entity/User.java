package com.ourhome.auth.entity;

import java.util.Date;

public class User {
	private int id;
	private String user_id;
	private String password;
	private String name;
	private Date birth;
	private char gender;
	private String image;
	
	public User() {
		
	}

	public User(String userId, String password, String name, Date birth, char gender, String image) {
		this.user_id = userId;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.image = image;
	}

	public int getId() {
		return id;
	}
	
	public String getUserId() {
		return user_id;
	}

	public void setUserId(String userId) {
		this.user_id = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [userId=" + user_id + ", password=" + password + ", name=" + name + ", birth=" + birth + ", gender="
				+ gender + ", image=" + image + "]";
	}
}
