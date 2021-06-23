package com.strip.safetrip.controller;

import com.strip.safetrip.domain.Travel;
import com.strip.safetrip.service.TravelService;
import com.strip.safetrip.tourApi.Requester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

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
