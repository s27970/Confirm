package com.confirm.confirm.controller;

import com.confirm.confirm.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class JobPostingController {
    private final JobPostingService jobService;

    @Autowired
    public JobPostingController(JobPostingService jobService) {
        this.jobService = jobService;
    }




}
