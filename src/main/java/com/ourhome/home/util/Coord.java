package com.ourhome.home.util;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

public class Coord {

    @Schema(description = "좌표의 위도값", requiredMode = RequiredMode.REQUIRED, minimum = "-90.0", maximum = "90.0")
    private Double lat;
    
    @Schema(description = "좌표의 경도값", requiredMode = RequiredMode.REQUIRED, minimum = "-180.0", maximum = "180.0")
    private Double lng;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

}
