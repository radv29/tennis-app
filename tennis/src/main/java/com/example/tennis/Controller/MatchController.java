package com.example.tennis.Controller;

import com.example.tennis.Model.Match;
import com.example.tennis.Model.Player;
import com.example.tennis.Repository.MatchRepository;
import com.example.tennis.Repository.PlayerRepository;
import com.example.tennis.Service.PlayerService;
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
