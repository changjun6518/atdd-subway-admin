package com.example.subway.domain.Line.service;

import com.example.subway.domain.Line.dao.Line;
import com.example.subway.domain.Line.dao.LineRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LineServiceTest {
    @Autowired
    LineRepository lineRepository;

    @Test
    void 노선추가기능() {
        // given
        Line line = Line.builder()
                .id(1L)
                .name("1호선")
                .color("파란색")
                .build();

        // when
        // 사용자가 노선추가 버튼을 눌렀을 때

        // then
        lineRepository.save(line);

    }

}