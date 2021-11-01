package com.example.subway.domain.LineStation.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LineStationRequest {

    private String lineName;

    private String prevStation;

    private String station;

    private Integer distance;

    private Integer duration;
}
