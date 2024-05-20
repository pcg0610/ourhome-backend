package com.ourhome.home.entity;

import java.util.Date;

public class Home {
	private long id;
	
	private String name;
	
	private String type;
	
	private String address;
	
	private int jeonsae;
	
	private int monthlyDeposit;
	
	private int monthlyPay;
	
	private double area;
	
	private int roomCnt;
	
	private String phone;
	
	private Date registeredDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getJeonsae() {
		return jeonsae;
	}

	public void setJeonsae(int jeonsae) {
		this.jeonsae = jeonsae;
	}

	public int getMonthlyDeposit() {
		return monthlyDeposit;
	}

	public void setMonthlyDeposit(int monthlyDeposit) {
		this.monthlyDeposit = monthlyDeposit;
	}

	public int getMonthlyPay() {
		return monthlyPay;
	}

	public void setMonthlyPay(int monthlyPay) {
		this.monthlyPay = monthlyPay;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public int getRoomCnt() {
		return roomCnt;
	}

	public void setRoomCnt(int roomCnt) {
		this.roomCnt = roomCnt;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	
}
