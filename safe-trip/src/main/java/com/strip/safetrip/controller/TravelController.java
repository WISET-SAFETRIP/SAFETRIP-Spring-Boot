package com.strip.safetrip.controller;

import com.strip.safetrip.domain.Travel;
import com.strip.safetrip.service.TravelService;
import com.strip.safetrip.tourApi.Requester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/travels")
public class TravelController {

    private final TravelService travelService;

    @Autowired
    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @PostMapping
    public ResponseEntity<?> addByGu() throws Exception {
        travelService.add(1);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @GetMapping(value = "/listByInsideAndFieldNo/{page}",
            // consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Travel>> listByInsideAndFieldNo(@PathVariable("page") Integer page) {
        return ResponseEntity.ok(travelService.listByInsideAndFieldNo(true, 1, PageRequest.of(1, 20)));
    }
}
