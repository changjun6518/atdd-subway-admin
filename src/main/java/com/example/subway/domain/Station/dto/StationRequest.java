package com.example.subway.domain.Station.dto;

import com.example.subway.domain.Station.dao.Station;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StationRequest {
    private String stationName;

    public StationRequest(String stationName) {
        this.stationName = stationName;
    }

    public Station toEntity() {
        return new Station(stationName);
    }


    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
