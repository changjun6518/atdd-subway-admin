package com.example.subway.domain.LineStation.api;

import com.example.subway.domain.LineStation.dto.LineStationRequest;
import com.example.subway.domain.LineStation.dto.LineStationResponse;
import com.example.subway.domain.LineStation.service.LineStationService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class LineStationRestController {

    private final LineStationService lineStationService;

    public LineStationRestController(LineStationService lineStationService) {
        this.lineStationService = lineStationService;
    }

    @PostMapping("/edges")
    public ResponseEntity<?> addEdges(@RequestBody LineStationRequest lineStationRequest) {
        System.out.println("lineStationRequest.toString() = " + lineStationRequest.toString());
        lineStationService.addEdges(lineStationRequest);
        return ResponseEntity.status(HttpStatus.OK).body("SaveSuccess");
    }

    @GetMapping("/edges")
    public ResponseEntity<List<LineStationResponse>> getEdges() {
        List<LineStationResponse> responses = lineStationService.getEdges();
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @GetMapping("/edges/{id}")
    public ResponseEntity<List<LineStationResponse>> getEdgesByLineId(@PathVariable Long id) {
        System.out.println("id = " + id);
        List<LineStationResponse> responses = lineStationService.getEdgesByLineId(id);
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @DeleteMapping("/edges/{id}")
    public ResponseEntity<?> deleteEdgeById(@PathVariable Long id) {
        lineStationService.deleteEdgeById(id);
        return ResponseEntity.status(HttpStatus.OK).body("deleteSuccess");
    }
}
