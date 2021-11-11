package com.example.subway.domain.Station.service;

import com.example.subway.domain.LineStation.dao.LineStation;
import com.example.subway.domain.LineStation.dao.LineStationRepository;
import com.example.subway.domain.Station.dao.Station;
import com.example.subway.domain.Station.dao.StationRepository;
import com.example.subway.domain.Station.dto.StationRequest;
import com.example.subway.domain.Station.dto.StationResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StationService {

    private final StationRepository stationRepository;
    private final LineStationRepository lineStationRepository;

    public StationService(StationRepository stationRepository, LineStationRepository lineStationRepository) {
        this.stationRepository = stationRepository;
        this.lineStationRepository = lineStationRepository;
    }

    public void addStation(StationRequest stationRequest) {
        Station station = stationRequest.toEntity();
        stationRepository.save(station);
    }

    public List<StationResponse> getStations() {
        return stationRepository
                .findAll()
                .stream()
                .map(StationResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteStation(Long stationId) {
        lineStationRepository.findAllByStationId(stationId)
                .forEach(edge -> edge.setStation(null));
        stationRepository.deleteById(stationId);
    }
}
