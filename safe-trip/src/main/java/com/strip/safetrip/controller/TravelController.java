package com.strip.safetrip.controller;

import com.strip.safetrip.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TravelController {

    private final TravelService travelService;

    @Autowired
    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping(value = "/travel/add")
    public void addByGu() throws Exception {
        travelService.add(1);
    }

}
