package com.confirm.confirm.controller;

import com.confirm.confirm.dto.PostingCardDTO;
import com.confirm.confirm.service.JobPostingService;
import com.confirm.confirm.service.RecommendationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController {

    private final JobPostingService jobService;
    private final RecommendationService recommendationService;

    @Autowired
    public MainPageController(JobPostingService jobService, RecommendationService recommendationService) {
        this.jobService = jobService;
        this.recommendationService = recommendationService;
    }

    @GetMapping("/mainpage")
    public String getJobList(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/login";
        }

        List<PostingCardDTO> postingCardDTOList = jobService.getAllJobs();
        List<PostingCardDTO> recommendations = recommendationService.getTop3Recommendations(userId);
        model.addAttribute("jobList", postingCardDTOList);
        model.addAttribute("recommendations", recommendations);
        return "mainpage";
    }

    @GetMapping("/jobPostingPage")
    public String jobPostingPage() {
        return "jobPostingPage"; // jobPostingPage.html로 이동
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}

