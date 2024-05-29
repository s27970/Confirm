package com.confirm.confirm.controller;

import com.confirm.confirm.dto.FairCardData;
import com.confirm.confirm.service.FairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FairListController {
    private final FairService fairService;

    @Autowired
    public FairListController(FairService fairService) {
        this.fairService = fairService;
    }

    @GetMapping("/fairList")
    public String getFairList(Model model) {
        List<FairCardData> fairListDataCard = fairService.getFairList();
        model.addAttribute("eventList", fairListDataCard);

        return "fairList";
    }
}
