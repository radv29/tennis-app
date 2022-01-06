package com.example.tennis.controller;

import com.example.tennis.dto.TournamentCreationDTO;
import com.example.tennis.dto.TournamentDTO;
import com.example.tennis.dto.TournamentPlayerDTO;
import com.example.tennis.mapper.TournamentCreationMapper;
import com.example.tennis.mapper.TournamentMapper;
import com.example.tennis.model.Tournament;
import com.example.tennis.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private TournamentCreationMapper tournamentCreationMapper;

    @Autowired
    private TournamentMapper tournamentMapper;

    @PostMapping("/add")
    public String add(@ModelAttribute("tournament") TournamentCreationDTO tournamentCreationDTO, BindingResult bindingResult){
        Tournament tournament = tournamentCreationMapper.DTOToModel(tournamentCreationDTO);
        this.tournamentService.saveTournament(tournament);
        return "tournaments";
    }

    @GetMapping("/add")
    public String addView(Model model){
        model.addAttribute("tournament", new TournamentCreationDTO());
        return "addTournament";
    }

    @PostMapping("/addPlayer")
    public String addPlayer(@ModelAttribute("tournamentPlayer") TournamentPlayerDTO tournamentPlayerDTO, BindingResult bindingResult){
        this.tournamentService.addPlayerToTournament(tournamentPlayerDTO.getTournamentId(),tournamentPlayerDTO.getPlayerId());
        return "tournaments";
    }

    @GetMapping("/addPlayer")
    public String addPlayerView(Model model){
        model.addAttribute("tournamentPlayer", new TournamentPlayerDTO());
        return "addPlayerToTournament";
    }

    @GetMapping("/all")
    public String getTournaments(Model model){
        List<TournamentDTO> tournamentList = new ArrayList<>();
        tournamentList = tournamentMapper.tournamentsToTournamentDTOs(this.tournamentService.findAllTournaments());
        model.addAttribute("tournaments", tournamentList);
        return "tournaments";
    }

    @GetMapping("/{tournamentId}")
    public String getTournament(@PathVariable String tournamentId, Model model){
        Tournament tournament = tournamentService.findTournamentById(tournamentId);
        TournamentDTO tournamentDTO = tournamentMapper.tournamentToTournamentDTO(tournament);
        model.addAttribute("tournament", tournamentDTO);
        model.addAttribute("players",tournamentDTO.getPlayers());
        return "tournamentPage";
    }

}
