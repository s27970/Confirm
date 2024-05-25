package com.confirm.confirm.controller;

import com.confirm.confirm.dto.PostingCardDTO;
import com.confirm.confirm.entity.Job;
import com.confirm.confirm.repository.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainPageController {

    private final JobRepository jobRepository;

    public MainPageController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @GetMapping("/")
    public String getJobList(Model model) {
        List<Job> jobList = jobRepository.findAll();

        // Job 리스트를 PostingCardDTO 리스트로 변환
        List<PostingCardDTO> postingCardDTOList = jobList.stream()
                .map(job -> new PostingCardDTO(
                        job.getImagePath(),
                        job.getCompanyName(),
                        job.getCompanySize(),
                        job.getIndustry(),
                        job.getPosition1(),
                        job.getPosition2()))
                .collect(Collectors.toList());

        model.addAttribute("jobList", postingCardDTOList);

        return "index";
    }
}
