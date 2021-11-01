package com.example.subway.domain.LineStation.dao;

import com.example.subway.domain.Line.dao.Line;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineStationRepository extends JpaRepository<LineStation, Long> {
}
