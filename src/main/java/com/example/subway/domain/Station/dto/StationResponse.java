package com.example.subway.domain.Station.dto;

import com.example.subway.domain.Station.dao.Station;

public class StationResponse {

    private Long stationId;
    private String stationName;

    public StationResponse(Long stationId, String stationName) {
        this.stationId = stationId;
        this.stationName = stationName;
    }

    public static StationResponse of(Station station) {
        return new StationResponse(station.getId(), station.getName());
    }

    public String getStationName() {
        return stationName;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
