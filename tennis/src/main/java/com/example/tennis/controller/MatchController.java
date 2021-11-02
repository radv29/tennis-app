package com.example.tennis.controller;

import com.example.tennis.model.Match;
import com.example.tennis.service.MatchService;
import com.example.tennis.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Autowired
    private PlayerService playerService;

    @PostMapping("/add")
    public void addMatch(@RequestBody Match match){
        this.matchService.saveMatch(match);

        this.playerService.updateMatchesPlayedAndWon(match);
    }

    @GetMapping("/all")
    public List<Match> getMatches(){
        return this.matchService.findAllMatches();
    }

}
