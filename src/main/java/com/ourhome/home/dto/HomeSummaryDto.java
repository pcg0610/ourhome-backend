package com.ourhome.home.dto;

import com.ourhome.home.util.HomeType;

public class HomeSummaryDto {

    private Long id;
    
	private String name;

	private HomeType type;
	
	private String address;
	
	private int jeonsae;
	
	private String monthlyDeposit;
	
	private String monthlyPay;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HomeType getType() {
		return type;
	}

	public void setType(HomeType type) {
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

	public String getMonthlyDeposit() {
		return monthlyDeposit;
	}

	public void setMonthlyDeposit(String monthlyDeposit) {
		this.monthlyDeposit = monthlyDeposit;
	}

	public String getMonthlyPay() {
		return monthlyPay;
	}

	public void setMonthlyPay(String monthlyPay) {
		this.monthlyPay = monthlyPay;
	}

}
