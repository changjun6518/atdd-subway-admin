package com.example.subway.domain.Station.dao;

import com.example.subway.domain.global.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Station extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_id")
    private Long id;

    private String name;
    private LocalDateTime createdAt;

    public Station(String name) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }

}
