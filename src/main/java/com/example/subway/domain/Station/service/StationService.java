package com.example.subway.domain.Station.service;

import com.example.subway.domain.Station.dao.Station;
import com.example.subway.domain.Station.dao.StationRepository;
import com.example.subway.domain.Station.dto.StationRequest;
import com.example.subway.domain.Station.dto.StationResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
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

    public void deleteStation(Long stationId) {
        stationRepository.deleteById(stationId);
    }
}
