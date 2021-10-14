package com.example.subway.domain.Line.service;

import com.example.subway.domain.Line.dao.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineService {
    @Autowired
    LineRepository lineRepository;


}
