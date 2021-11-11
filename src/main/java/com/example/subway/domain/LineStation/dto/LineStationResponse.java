package com.example.subway.domain.LineStation.dto;

import com.example.subway.domain.LineStation.dao.LineStation;
import lombok.Getter;

@Getter
public class LineStationResponse {

    private final Long edgeId;
    private final String station;
    private final String line;
    private final String lineColor;

    public LineStationResponse(Long edgeId, String station, String line, String lineColor) {
        this.edgeId = edgeId;
        this.station = station;
        this.line = line;
        this.lineColor = lineColor;
    }

    public static LineStationResponse of(LineStation lineStation) {
        return new LineStationResponse(lineStation.getId(), lineStation.getStation().getName(),
                lineStation.getLine().getName(), lineStation.getLine().getColor());
    }
}
