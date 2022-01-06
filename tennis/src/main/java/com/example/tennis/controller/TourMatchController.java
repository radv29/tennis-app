package com.example.tennis.controller;

import com.example.tennis.dto.WinnerDTO;
import com.example.tennis.service.TourMatchService;
import com.example.tennis.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tournaments/matches")
public class TourMatchController {

    @Autowired
    private TourMatchService tourMatchService;

    @Autowired
    private TournamentService tournamentService;

    @PostMapping("/updateWinner")
    public String updateWinner(@ModelAttribute("winner") WinnerDTO winnerDTO, BindingResult bindingResult){
        tourMatchService.updateMatchWinner(winnerDTO.getTourMatchId(), winnerDTO.getPlayerNumber(), winnerDTO.getFirstPlayersScore(), winnerDTO.getSecondPlayersScore());
        return "updateMatch";
    }

    @GetMapping("/updateWinner")
    public String viewUpdateWinner(Model model){
        model.addAttribute("winner", new WinnerDTO());
        return "updateMatch";
    }

    @PostMapping("/drawPlayers/{tournamentId}")
    public String drawPlayers(@PathVariable String tournamentId){
        tourMatchService.drawMatches(tournamentService.findTournamentById(tournamentId));
        return "drawPage";
    }

    @GetMapping("/drawPlayers/{tournamentId}")
    public String getDraw(@PathVariable String tournamentId,Model model){
        model.addAttribute("tournamentId",tournamentId);
        return "drawPage";
    }

    @GetMapping("/{tournamentId}")
    public String getTourMatch(@PathVariable String tournamentId, Model model){
        model.addAttribute("tourMatches", tourMatchService.findTourMatchesByTournamentId(tournamentId));
        return "matchesPage";
    }

}
