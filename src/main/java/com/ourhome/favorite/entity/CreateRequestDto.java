package com.ourhome.favorite.entity;

public class CreateRequestDto {
    Long userId;
    Long homeId;

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
}
