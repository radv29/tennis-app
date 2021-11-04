//package com.example.tennis.controller;
//
//import com.example.tennis.model.TourMatch;
//import com.example.tennis.model.Tournament;
//import com.example.tennis.service.TourMatchService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/tournaments/matches")
//public class TourMatchController {
//
//    @Autowired
//    private TourMatchService tourMatchService;
//
//    @PostMapping("/add")
//    public void add(@RequestBody TourMatch tourMatch){
//        this.tourMatchService.saveTourMatch(tourMatch);
//    }
//
//    @GetMapping("/all")
//    public List<Tournament> getMatchesFromTournament(){
//        return this.tournamentService.findAllTournaments();
//    }
//
//}
