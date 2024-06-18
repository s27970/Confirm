package com.confirm.confirm.controller;

import com.confirm.confirm.dto.PostingCardDTO;
import com.confirm.confirm.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyPageController {

    private final JobPostingService jobService;

    @Autowired
    public MyPageController(JobPostingService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/mypage")
    public String myPage() {
        return "mypage";
    }

}
