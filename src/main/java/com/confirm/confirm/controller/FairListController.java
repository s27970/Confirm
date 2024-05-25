package com.confirm.confirm.controller;

import com.confirm.confirm.service.FairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FairListController {
    private final FairService fairService;

    @Autowired
    public FairListController(FairService fairService) {
        this.fairService = fairService;
    }

    @GetMapping("/fairlist")
    public String getFairList(Model model) {
        model.addAttribute("fairs", fairService.getFairList());

        return "fairList.html";
    }
}
