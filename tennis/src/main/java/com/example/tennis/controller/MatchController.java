package com.example.tennis.controller;

import com.example.tennis.model.Match;
import com.example.tennis.model.Player;
import com.example.tennis.repository.MatchRepository;
import com.example.tennis.repository.PlayerRepository;
import com.example.tennis.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private Player player;

    @Autowired
    private Match match;

    @PostMapping("/add")
    public void addMatch(@RequestBody Match match){
        this.matchRepository.save(match);

        String idOfWinner = match.getWinner().getId();
        String idOfLoser = match.getLoser().getId();
        Player winner = playerRepository.findById(idOfWinner).orElse(null);
        Player loser = playerRepository.findById(idOfLoser).orElse(null);
        winner.setMatchesWon(playerService.setMatchesWon(match.getWinner()));
        loser.setMatchesWon(playerService.setMatchesWon(match.getLoser()));
        winner.setMatchesPlayed(playerService.setMatchesLost(match.getWinner())+playerService.setMatchesWon(match.getWinner()));
        loser.setMatchesPlayed(playerService.setMatchesLost(match.getLoser())+playerService.setMatchesWon(match.getLoser()));

        playerRepository.save(winner);
        playerRepository.save(loser);
    }

    @GetMapping("/all")
    public List<Match> getMatches(){
        return this.matchRepository.findAll();
    }

//    @GetMapping("/allwon/{playerid}")
//    public int getMatchesWonByAPlayer(@PathVariable("playerid") String id){
//        return this.playerService.setMatchesWon(id);
//    }

}
