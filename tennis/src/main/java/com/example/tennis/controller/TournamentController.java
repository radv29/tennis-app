package com.example.tennis.controller;

import com.example.tennis.model.Tournament;
import com.example.tennis.service.IdRead;
import com.example.tennis.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private IdRead idRead;

    @PostMapping("/add")
    public void add(@RequestBody Tournament tournament){
        this.tournamentService.saveTournament(tournament);
    }

    @PostMapping("/addPlayer")
    public void addPlayer(@RequestBody IdRead idRead){
        String tournamentId = idRead.getTournamentId();
        String playerId = idRead.getPlayerId();
        this.tournamentService.addPlayerToTournament(tournamentId,playerId);
    }

    @GetMapping("/all")
    public List<Tournament> getTournaments(){
        return this.tournamentService.findAllTournaments();
    }

}
