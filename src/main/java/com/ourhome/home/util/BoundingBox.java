package com.ourhome.home.util;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

public class BoundingBox {

    @Schema(description = "남서쪽 좌표", requiredMode = RequiredMode.REQUIRED)
    private Coord southWestCoord;
    
    @Schema(description = "북동쪽 좌표", requiredMode = RequiredMode.REQUIRED)
    private Coord northEastCoord;

    public Coord getSouthWestCoord() {
        return southWestCoord;
    }

    public void setSouthWestCoord(Coord southWestCoord) {
        this.southWestCoord = southWestCoord;
    }

    public Coord getNorthEastCoord() {
        return northEastCoord;
    }

    public void setNorthEastCoord(Coord northEastCoord) {
        this.northEastCoord = northEastCoord;
    }
    
}
