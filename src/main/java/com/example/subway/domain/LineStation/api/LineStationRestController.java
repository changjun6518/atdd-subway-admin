package com.example.subway.domain.LineStation.api;

import com.example.subway.domain.LineStation.dto.LineStationRequest;
import com.example.subway.domain.LineStation.dto.LineStationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class LineStationRestController {

    @PostMapping("/edges")
    public ResponseEntity<?> addEdges(@RequestBody LineStationRequest lineStationRequest) {
        System.out.println("lineStationRequest.toString() = " + lineStationRequest.toString());
        // TODO - 서비스 로직을 구현한다.
        return ResponseEntity.status(HttpStatus.OK).body("SaveSuccess");
    }

    @GetMapping("/edges")
    public ResponseEntity<LineStationResponse> getEdges() {
        // TODO - 서비스 로직을 구현한다.
        return ResponseEntity.status(HttpStatus.OK).body(new LineStationResponse());
    }
}
