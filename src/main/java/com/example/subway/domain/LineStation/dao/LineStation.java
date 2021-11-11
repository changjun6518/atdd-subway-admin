package com.example.subway.domain.LineStation.dao;

import com.example.subway.domain.Station.dao.Station;
import com.example.subway.domain.global.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LineStation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "line_station_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "station_id")
    private Station station;

    @OneToOne
    @JoinColumn(name = "station_id")
    private Station prevStation;

    private Long distance;
    private Long duration;

}
