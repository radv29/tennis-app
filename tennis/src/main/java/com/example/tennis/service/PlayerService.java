package com.example.tennis.service;

import com.example.tennis.model.Match;
import com.example.tennis.model.Player;
import com.example.tennis.repository.MatchRepository;
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
