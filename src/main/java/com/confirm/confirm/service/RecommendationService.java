package com.confirm.confirm.service;

import com.confirm.confirm.dto.PostingCardDTO;
import com.confirm.confirm.entity.HIRE;
import com.confirm.confirm.entity.UserLog;
import com.confirm.confirm.repository.HireRepository;
import com.confirm.confirm.repository.UserLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private UserLogRepository userLogRepository;

    @Autowired
    private HireRepository hireRepository;

    public List<PostingCardDTO> getTop3Recommendations(Long userId) {
        List<UserLog> userLogs = userLogRepository.findByUserId(userId);

        Map<String, Integer> majorCount = new HashMap<>();
        Map<String, Integer> jobCategoryCount = new HashMap<>();
        Map<String, Integer> industryCount = new HashMap<>();
        Map<String, Integer> position1Count = new HashMap<>();

        for (UserLog log : userLogs) {
            HIRE hire = hireRepository.findById((int) Long.parseLong(log.getDetails())).orElse(null);
            if (hire != null) {
                majorCount.put(hire.getMajor(), majorCount.getOrDefault(hire.getMajor(), 0) + 1);
                jobCategoryCount.put(hire.getJobCategory(), jobCategoryCount.getOrDefault(hire.getJobCategory(), 0) + 1);
                industryCount.put(hire.getIndustry(), industryCount.getOrDefault(hire.getIndustry(), 0) + 1);
                position1Count.put(hire.getPosition1(), position1Count.getOrDefault(hire.getPosition1(), 0) + 1);
            }
        }

        List<HIRE> allHires = hireRepository.findAll();

        Map<HIRE, Integer> hireScores = new HashMap<>();

        for (HIRE hire : allHires) {
            if (!userLogs.stream().anyMatch(log -> Long.parseLong(log.getDetails()) == hire.getId())) {
                int score = 0;
                score += majorCount.getOrDefault(hire.getMajor(), 0);
                score += jobCategoryCount.getOrDefault(hire.getJobCategory(), 0);
                score += industryCount.getOrDefault(hire.getIndustry(), 0);
                score += position1Count.getOrDefault(hire.getPosition1(), 0);
                hireScores.put(hire, score);
            }
        }

        List<HIRE> top3Hires = hireScores.entrySet().stream()
                .sorted(Map.Entry.<HIRE, Integer>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return top3Hires.stream()
                .map(hire -> new PostingCardDTO(hire.getImagePath(), hire.getCompanyName(), hire.getCompanySize(), hire.getIndustry(), hire.getPosition1(), hire.getPosition2()))
                .collect(Collectors.toList());
    }
}
