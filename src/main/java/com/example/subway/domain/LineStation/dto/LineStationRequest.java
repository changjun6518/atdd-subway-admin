package com.example.subway.domain.LineStation.dto;

import com.example.subway.domain.Line.dao.Line;
import com.example.subway.domain.LineStation.dao.LineStation;
import com.example.subway.domain.Station.dao.Station;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LineStationRequest {

    private String lineName;

    private String prevStation;

    private String station;

    private Long distance;

    private Long duration;


    public LineStation toEntity(Line line, Station station, Station prevStation) {
        return LineStation.builder()
                .line(line)
                .station(station)
                .prevStation(prevStation)
                .distance(distance)
                .duration(duration)
                .build();
    }
}
