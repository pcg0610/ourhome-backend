package com.ourhome.home.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotBlank;

public class FavoriteEntity {

	@Schema(requiredMode = RequiredMode.REQUIRED, description = "즐겨찾기한 사용자의 고유번호")
	@NotBlank(message = "즐겨찾기한 사용자의 고유번호가 없습니다.")
	private Long userId;

	@Schema(requiredMode = RequiredMode.REQUIRED, description = "즐겨찾기한 매물의 고유번호")
	@NotBlank(message = "즐겨찾기한 매물의 고유번호가 없습니다.")
	private Long homeId;

	public FavoriteEntity() {

	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getHomeId() {
		return homeId;
	}

	public void setHomeId(Long homeId) {
		this.homeId = homeId;
	}

	public FavoriteEntity(Long userId, Long homeId) {
		super();
		this.userId = userId;
		this.homeId = homeId;
	}

}
