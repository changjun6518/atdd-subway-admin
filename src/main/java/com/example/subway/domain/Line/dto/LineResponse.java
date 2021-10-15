package com.example.subway.domain.Line.dto;

import com.example.subway.domain.Line.dao.Line;
import lombok.Builder;

import java.time.LocalTime;

@Builder
public class LineResponse {
    private String name;

    private LocalTime firstTime;

    private LocalTime lastTime;

    private String color;

    private Long intervalTime;

    public static LineResponse of(Line line) {
        return LineResponse.builder()
                .name(line.getName())
                .color(line.getColor())
                .firstTime(line.getFirstTime())
                .lastTime(line.getLastTime())
                .intervalTime(line.getIntervalTime())
                .build();
    }
}
