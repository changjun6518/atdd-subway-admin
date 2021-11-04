package com.example.subway.domain.LineStation.service;

import com.example.subway.domain.Line.dao.Line;
import com.example.subway.domain.Line.dao.LineRepository;
import com.example.subway.domain.LineStation.dao.LineStationRepository;
import com.example.subway.domain.LineStation.dto.LineStationRequest;
import com.example.subway.domain.LineStation.dto.LineStationResponse;
import com.example.subway.domain.Station.dao.Station;
import com.example.subway.domain.Station.dao.StationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LineStationService {

    private final LineStationRepository lineStationRepository;
    private final StationRepository stationRepository;
    private final LineRepository lineRepository;

    public LineStationService(LineStationRepository lineStationRepository, StationRepository stationRepository,
                              LineRepository lineRepository) {
        this.lineStationRepository = lineStationRepository;
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
    }

    @Transactional
    public void addEdges(LineStationRequest lineStationRequest) {
        Line line = lineRepository.findByName(lineStationRequest.getLineName())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 라인입니다."));
        Station station = stationRepository.findByName(lineStationRequest.getStation())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 역입니다."));
        Station prevStation = stationRepository.findByName(lineStationRequest.getPrevStation())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 역입니다."));

        lineStationRepository.save(lineStationRequest.toEntity(line, station, prevStation));
    }

    public List<LineStationResponse> getEdges() {
        return lineStationRepository.findAll()
                                .stream()
                                .map(LineStationResponse::of)
                                .collect(Collectors.toList());
    }
}
