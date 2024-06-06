package com.ourhome.home.util;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.Size;

public class SearchCondition {

	@Schema(description = "매물 이름으로 조회하기 위한 변수", requiredMode = RequiredMode.NOT_REQUIRED)
	@Size(max = 30, message = "이름의 길이는 최대 30자 입니다.")
	private String name;

	@Schema(description = "주소지로 조회하기 위한 변수", example = "서울", requiredMode = RequiredMode.NOT_REQUIRED)
	@Size(max = 30, message = "주소지의 길이는 최대 30자 입니다.")
	private String address;

	@Schema(description = "조회할 매물 개수", defaultValue = "20", requiredMode = RequiredMode.NOT_REQUIRED)
	private int limit;

	@Schema(description = "특정 좌표 내의 매물을 조회하기 위한 변수", requiredMode = RequiredMode.NOT_REQUIRED)
	private BoundingBox boundingBox;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public BoundingBox getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
	}

}
