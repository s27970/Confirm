package com.confirm.confirm.service;

import com.confirm.confirm.dto.PostingCardDTO;
import com.confirm.confirm.entity.HIRE;
import com.confirm.confirm.repository.HireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobPostingService {

    private final HireRepository jobRepository;
@Autowired
    public JobPostingService(HireRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<PostingCardDTO> getAllJobs() {
        List<HIRE> jobList = jobRepository.findAll();
        System.out.println("list : ");
        jobList.forEach(job -> System.out.println(job.toString()));
        // Job 리스트를 PostingCardDTO 리스트로 변환
        return jobList.stream()
                .map(job -> new PostingCardDTO(
                        job.getImagePath(),
                        job.getCompanyName(),
                        job.getCompanySize(),
                        job.getIndustry(),
                        job.getPosition1(),
                        job.getPosition2()))
                .toList();
    }


}

