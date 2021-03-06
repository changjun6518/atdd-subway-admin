package com.example.subway.domain.Station.dao;

import com.example.subway.domain.Line.dao.Line;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, Long> {
    Optional<Station> findByName(String name);
}
