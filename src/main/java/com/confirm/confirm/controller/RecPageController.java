package com.confirm.confirm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecPageController {
    @GetMapping("/jobRec")
    public String jobRec() {
        return "jobRec"; // jobRec.html로 이동
    }

    @GetMapping("/eventRec")
    public String eventRec() {
        return "eventRec"; // eventRec.html로 이동
    }
}
