package com.example.subway.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("admin-line")
    public String getLinePage() {
        return "line/admin-line";
    }

    @GetMapping("admin-line-form")
    public String getLineForm() {
        return "line/admin-line-form";
    }

    @GetMapping("admin-edge")
    public String getEdgePage() {
        return "edge/admin-edge";
    }

    @GetMapping("admin-edge-form")
    public String getEdgeForm() {
        return "edge/admin-edge-form";
    }
}
