package com.example.subway.domain.Station.api;

import com.example.subway.domain.Station.dto.StationRequest;
import com.example.subway.domain.Station.dto.StationResponse;
import com.example.subway.domain.Station.service.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class StationRestController {

    private final StationService stationService;

    public StationRestController(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping("stations")
    public ResponseEntity<String> addStation(@RequestBody StationRequest stationRequest) {
        stationService.addStation(stationRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

    @GetMapping("stations")
    public ResponseEntity<List<StationResponse>> getStations() {
        List<StationResponse> stations = stationService.getStations();
        return ResponseEntity.status(HttpStatus.OK).body(stations);
    }

    @DeleteMapping("stations")
    public ResponseEntity<String> deleteStation(@RequestParam("id") Long id) {
        stationService.deleteStation(id);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
}
