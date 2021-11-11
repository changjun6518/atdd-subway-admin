package com.example.subway.domain.Line.dao;

import com.example.subway.domain.Line.dto.LineRequest;
import com.example.subway.domain.LineStation.dao.LineStation;
import com.example.subway.domain.global.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Line extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "line_id")
    private Long id;

    private String name;
    private LocalTime firstTime;
    private LocalTime lastTime;
    private String color;
    private Long intervalTime;

    @OneToMany
    private Set<LineStation> lineStations = new HashSet<>();

    public void update(LineRequest lineRequest) {
        name = lineRequest.getName();
        firstTime = lineRequest.getFirstTime();
        lastTime = lineRequest.getLastTime();
        color = lineRequest.getColor();
        intervalTime = lineRequest.getIntervalTime();
    }
}
