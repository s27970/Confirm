package com.confirm.confirm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MentorController {

    @GetMapping("/mentor")
    public String getMentoList() {
        return "mentor";
    }
}
