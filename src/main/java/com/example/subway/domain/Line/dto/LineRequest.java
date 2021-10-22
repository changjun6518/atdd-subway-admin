package com.example.subway.domain.Line.dto;

import com.example.subway.domain.Line.dao.Line;

import java.time.LocalTime;

public class LineRequest {

    private String name;

    private LocalTime firstTime;

    private LocalTime lastTime;

    private String color;

    private Long intervalTime;

    public LineRequest(String name, LocalTime firstTime, LocalTime lastTime, String color, Long intervalTime) {
        this.name = name;
        this.firstTime = firstTime;
        this.lastTime = lastTime;
        this.color = color;
        this.intervalTime = intervalTime;
    }

    public LineRequest() {
    }

    public String getName() {
        return name;
    }

    public LocalTime getFirstTime() {
        return firstTime;
    }

    public LocalTime getLastTime() {
        return lastTime;
    }

    public String getColor() {
        return color;
    }

    public Long getIntervalTime() {
        return intervalTime;
    }

    public Line createLine() {
        return Line.builder()
                .name(name)
                .color(color)
                .firstTime(firstTime)
                .lastTime(lastTime)
                .intervalTime(intervalTime)
                .build();
    }
}
