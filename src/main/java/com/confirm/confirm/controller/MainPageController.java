package com.confirm.confirm.controller;

import com.confirm.confirm.dto.PostingCardDTO;
import com.confirm.confirm.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController {

    private final JobPostingService jobService;

    @Autowired
    public MainPageController(JobPostingService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/")
    public String getJobList(Model model) {
        List<PostingCardDTO> postingCardDTOList = jobService.getAllJobs();
        model.addAttribute("jobList", postingCardDTOList);
        return "mainpage";
    }
    @GetMapping("/mainpage")
    public String mainpage() {
        return "mainpage"; // mainpage.html로 이동
    }

    @GetMapping("/jobPostingPage")
    public String jobPostingPage() {
        return "jobPostingPage"; // jobPostingPage.html로 이동
    }

    @GetMapping("/fairList")
    public String fairList() {
        return "fairList"; // fairList.html로 이동
    }

    @GetMapping("/jobRec")
    public String jobRec() {
        return "jobRec"; // jobRec.html로 이동
    }

    @GetMapping("/logib")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

}

