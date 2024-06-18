package com.confirm.confirm.service;

import com.confirm.confirm.dto.PostingCardDTO;
import com.confirm.confirm.entity.HIRE;
import com.confirm.confirm.entity.User;
import com.confirm.confirm.entity.UserLog;
import com.confirm.confirm.repository.HireRepository;
import com.confirm.confirm.repository.UserLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingService {

    private final HireRepository jobRepository;
    private final UserLogRepository userLogRepository;

    @Autowired
    public JobPostingService(HireRepository jobRepository, UserLogRepository userLogRepository) {
        this.jobRepository = jobRepository;
        this.userLogRepository = userLogRepository;
    }

    public List<PostingCardDTO> getAllJobs() {
        List<HIRE> jobList = jobRepository.findAll();
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

    public void logJobClick(User user, Long jobId) {
        HIRE job = jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));
        UserLog userLog = new UserLog("CLICK", job.getCompanyName() + " - " + job.getPosition1(), user);
        userLogRepository.save(userLog);
    }
}
