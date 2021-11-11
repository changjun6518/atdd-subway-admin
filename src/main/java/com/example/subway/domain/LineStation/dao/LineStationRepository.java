package com.example.subway.domain.LineStation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineStationRepository extends JpaRepository<LineStation, Long> {
    List<LineStation> findAllByLineId(Long id);
    List<LineStation> findAllByStationId(Long id);
    void deleteAllByStationId(Long id);
    void deleteAllByLineId(Long id);
}
