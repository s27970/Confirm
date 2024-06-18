package com.confirm.confirm.controller;

import com.confirm.confirm.dto.PostingCardDTO;
import com.confirm.confirm.entity.User;
import com.confirm.confirm.service.JobPostingService;
import com.confirm.confirm.service.RecommendationService;
import com.confirm.confirm.service.UserDetailService;
import com.confirm.confirm.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller
public class MainPageController {
    private static final Logger log = LoggerFactory.getLogger(MainPageController.class);

    private final JobPostingService jobService;
    private final RecommendationService recommendationService;
    private final UserService userService;

    @Autowired
    public MainPageController(JobPostingService jobService, RecommendationService recommendationService, UserService userService) {
        this.jobService = jobService;
        this.recommendationService = recommendationService;
        this.userService = userService;
    }

    @GetMapping("/mainpage")
    public String getJobList(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        log.info("Session userId: {}", userId);

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
        return "jobPostingPage";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/job/{id}/click")
    public String clickJob(@PathVariable Long id, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            try {
                User user = userService.findById(userId);
                jobService.logJobClick(user, id);
            } catch (Exception e) {
                log.error("Error logging job click for user: {}", userId, e);
            }
        }
        return "redirect:/mainpage";
    }
}
