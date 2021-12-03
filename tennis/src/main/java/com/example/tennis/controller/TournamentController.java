package com.example.tennis.controller;

import com.example.tennis.dto.TournamentCreationDTO;
import com.example.tennis.dto.TournamentDTO;
import com.example.tennis.dto.TournamentPlayerDTO;
import com.example.tennis.mapper.TournamentCreationMapper;
import com.example.tennis.mapper.TournamentMapper;
import com.example.tennis.model.Tournament;
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
    private TournamentCreationMapper tournamentCreationMapper;

    @Autowired
    private TournamentMapper tournamentMapper;

    @PostMapping(value = "/add")
    public void add(@RequestBody TournamentCreationDTO tournamentCreationDTO){
        Tournament tournament = tournamentCreationMapper.DTOToModel(tournamentCreationDTO);
        this.tournamentService.saveTournament(tournament);
    }

    @PostMapping("/addPlayer")
    public void addPlayer(@RequestBody TournamentPlayerDTO tournamentPlayerDTO){
        String tournamentId = tournamentPlayerDTO.getTournamentId();
        String playerId = tournamentPlayerDTO.getPlayerId();
        this.tournamentService.addPlayerToTournament(tournamentId,playerId);
    }

    @GetMapping("/all")
    public List<TournamentDTO> getTournaments(){
        return tournamentMapper.tournamentsToTournamentDTOs(this.tournamentService.findAllTournaments());
    }

}
