package com.example.subway.domain.LineStation.service;

import com.example.subway.domain.Line.dao.Line;
import com.example.subway.domain.Line.dao.LineRepository;
import com.example.subway.domain.LineStation.dao.LineStation;
import com.example.subway.domain.LineStation.dao.LineStationRepository;
import com.example.subway.domain.LineStation.dto.LineStationRequest;
import com.example.subway.domain.LineStation.dto.LineStationResponse;
import com.example.subway.domain.Station.dao.Station;
import com.example.subway.domain.Station.dao.StationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    public List<LineStationResponse> getEdgesByLineId(Long lineId) {
        List<LineStation> edges = lineStationRepository.findAllByLineId(lineId);

        List<LineStation> orderedEdges = new ArrayList<>();
        getOrderedEdges(orderedEdges, edges, "출발역");

        for (LineStation orderedEdge : orderedEdges) {
            System.out.println("orderedEdge = " + orderedEdge.getStation().getName());
        }

        return orderedEdges.stream()
                .map(LineStationResponse::of)
                .collect(Collectors.toList());
    }

    private void getOrderedEdges(List<LineStation> orderedEdges, List<LineStation> edges, String currentStation) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getPrevStation().getName().equals(currentStation)) {
                getOrderedEdges(orderedEdges, edges, edges.get(i).getStation().getName());
                orderedEdges.add(edges.get(i));
            }
        }
    }

    @Transactional
    public void deleteEdgeById(Long id) {
        lineStationRepository.deleteById(id);
    }
}
