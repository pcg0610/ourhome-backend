package com.ourhome.chat.entity;

public class CreateRequestDto {
	private long homeId;
	
	private String name;

	public long getHomeId() {
		return homeId;
	}

	public void setHomeId(long homeId) {
		this.homeId = homeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CreateRequestDto [homeId=" + homeId + ", name=" + name + "]";
	}

}
