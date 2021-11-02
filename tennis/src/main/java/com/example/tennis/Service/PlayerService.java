package com.example.tennis.Service;

import com.example.tennis.Model.Match;
import com.example.tennis.Model.Player;
import com.example.tennis.Repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private MatchRepository matchRepository;

    public int setMatchesWon(Player player){
        List<Match> matchesWon = matchRepository.findAllByWinner(player.getId());
        return matchesWon.size();
    }

    public int setMatchesLost(Player player){
        List<Match> matchesPlayed = matchRepository.findAllByLoser(player.getId());
        return matchesPlayed.size();
    }

}
