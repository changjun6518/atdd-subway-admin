package com.example.subway.domain.Line.dao;

import com.example.subway.domain.Line.dto.LineRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "line_id")
    private Long id;

    private String name;
    private LocalTime firstTime;
    private LocalTime lastTime;
    private String color;
    private Long intervalTime;

    public void update(LineRequest lineRequest) {
        name = lineRequest.getName();
        firstTime = lineRequest.getFirstTime();
        lastTime = lineRequest.getLastTime();
        color = lineRequest.getColor();
        intervalTime = lineRequest.getIntervalTime();
    }
}
