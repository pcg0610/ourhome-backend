package com.ourhome.home.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

public class Area {

    @Schema(description = "최소 위도 좌표", requiredMode = RequiredMode.REQUIRED)
    private double minLat;

    @Schema(description = "최소 경도 좌표", requiredMode = RequiredMode.REQUIRED)
    private double minLng;

    @Schema(description = "최대 위도 좌표", requiredMode = RequiredMode.REQUIRED)
    private double maxLat;

    @Schema(description = "최대 경도 좌표", requiredMode = RequiredMode.REQUIRED)
    private double maxLng;

    public double getMinLat() {
        return minLat;
    }

    public void setMinLat(double minLat) {
        this.minLat = minLat;
    }

    public double getMinLng() {
        return minLng;
    }

    public void setMinLng(double minLng) {
        this.minLng = minLng;
    }

    public double getMaxLat() {
        return maxLat;
    }

    public void setMaxLat(double maxLat) {
        this.maxLat = maxLat;
    }

    public double getMaxLng() {
        return maxLng;
    }

    public void setMaxLng(double maxLng) {
        this.maxLng = maxLng;
    }
}
