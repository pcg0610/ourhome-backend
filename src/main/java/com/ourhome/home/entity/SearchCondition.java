package com.ourhome.home.entity;

public class SearchCondition {
	
	private String address;
	
	private String name;
	
	private MatchType matchType = MatchType.AND;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MatchType getMatchType() {
		return matchType;
	}

	public void setMatchType(MatchType matchType) {
		this.matchType = matchType;
	}
	
	public String getMatchTypeName() {
		return matchType.name();
	}

	@Override
	public String toString() {
		return "SearchCondition [address=" + address + ", name=" + name + ", matchType=" + matchType + "]";
	}
	
}
