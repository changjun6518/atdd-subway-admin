package com.example.subway.domain.Line.service;

import com.example.subway.domain.Line.dao.Line;
import com.example.subway.domain.Line.dao.LineRepository;
import com.example.subway.domain.Line.dto.LineRequest;
import com.example.subway.domain.Line.dto.LineResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineService {

    private final LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public void addLine(LineRequest lineRequest) {
        System.out.println(lineRequest.getColor());
        Line newLine = lineRequest.createLine();
        lineRepository.save(newLine);
    }

    public List<LineResponse> getLines() {
        List<Line> lines = lineRepository.findAll();
        return lines.stream()
                    .map(LineResponse::of)
                    .collect(Collectors.toList());
    }

    public LineResponse getLine(Long id) {
        Line line = lineRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 호선입니다.")
        );
        return LineResponse.of(line);
    }

    @Transactional
    public LineResponse updateLine(Long id, LineRequest lineRequest) {
        Line line = lineRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 호선입니다.")
        );
        line.update(lineRequest);
        return LineResponse.of(line);
    }

    public void deleteLine(Long id) {
        lineRepository.deleteById(id);
    }
}
