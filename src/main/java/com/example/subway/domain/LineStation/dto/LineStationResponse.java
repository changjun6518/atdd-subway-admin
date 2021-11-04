package com.example.subway.domain.LineStation.dto;

import com.example.subway.domain.LineStation.dao.LineStation;
import lombok.Getter;

@Getter
public class LineStationResponse {

    private String station;
    private String line;

    public LineStationResponse(String station, String line) {
        this.station = station;
        this.line = line;
    }

    public static LineStationResponse of(LineStation lineStation) {
        return new LineStationResponse(lineStation.getStation().getName(), lineStation.getLine().getName());
    }
}
