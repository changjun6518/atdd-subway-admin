package com.example.subway.domain.Line.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class LineRepositoryTest {

    @Autowired
    LineRepository lineRepository;

    @Test
    @Transactional
    void 저장_테스트() {
        Line line1 = Line.builder()
                .id(1L)
                .name("1호선")
                .color("파란색")
                .build();

        Line savedLine = lineRepository.save(line1);

        Line byId = lineRepository.getById(1L);

        System.out.println("savedLine = " + savedLine.getName());
        System.out.println("byId.getName() = " + byId.getName());

        Assertions.assertThat(savedLine.getName()).isEqualTo(byId.getName());

    }
}