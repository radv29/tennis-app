package com.example.tennis.controller;

import com.example.tennis.model.Tournament;
import com.example.tennis.repository.TournamentRepository;
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
    private TournamentRepository tournamentRepository;

    @PostMapping("/add")
    public void add(@RequestBody Tournament tournament){
        this.tournamentService.saveTournament(tournament);
    }

    @PostMapping("/addPlayer")
    public void addPlayer(String tournamentId, String playerId){
        if(tournamentId == null)
            System.out.println("dgasg");
        else{
        this.tournamentService.addPlayerToTournament(tournamentId,playerId);
        Tournament tournament = tournamentRepository.findById(tournamentId).orElse(null);
        tournamentRepository.save(tournament);
        }
    }

    @GetMapping("/all")
    public List<Tournament> getTournaments(){
        return this.tournamentService.findAllTournaments();
    }

}
