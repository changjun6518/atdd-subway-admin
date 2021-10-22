package com.example.subway.domain.Line.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LineController {

    @GetMapping("admin-line")
    public String getLinePage() {
        return "line/admin-line";
    }

    @GetMapping("admin-line-form")
    public String getLineFrom() {
        return "line/admin-line-form";
    }
}
