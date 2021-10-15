package com.example.subway.domain.Line.api;

import com.example.subway.domain.Line.dao.Line;
import com.example.subway.domain.Line.dto.LineRequest;
import com.example.subway.domain.Line.dto.LineResponse;
import com.example.subway.domain.Line.service.LineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class LineController {

    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @PostMapping("/")
    public ResponseEntity<String> addLine(@RequestBody LineRequest lineRequest) {
        lineService.addLine(lineRequest);
        return ResponseEntity.status(HttpStatus.OK).body("SaveSuccess");
    }

    @GetMapping("/lines")
    public ResponseEntity<List<LineResponse>> getLines() {
        List<LineResponse> response = lineService.getLines();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/lines/{id}")
    public ResponseEntity<LineResponse> getLine(@PathVariable Long id) {
        LineResponse response = lineService.getLine(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/lines/{id}")
    public ResponseEntity<LineResponse> updateLine(@PathVariable Long id, @RequestBody LineRequest lineRequest) {
        LineResponse response = lineService.updateLine(id, lineRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/lines/{id}")
    public ResponseEntity<String> deleteLine(@PathVariable Long id) {
        lineService.deleteLine(id);
        return ResponseEntity.status(HttpStatus.OK).body("DeleteSuccess");
    }
}
