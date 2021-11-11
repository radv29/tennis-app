package com.example.tennis.controller;

import com.example.tennis.model.TourMatch;
import com.example.tennis.service.TourMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tournaments/matches")
public class TourMatchController {

    @Autowired
    private TourMatchService tourMatchService;

    @PostMapping("/add")
    public void add(@RequestBody TourMatch tourMatch){
        this.tourMatchService.saveTourMatch(tourMatch);
    }

}
