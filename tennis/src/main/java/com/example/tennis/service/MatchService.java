package com.example.tennis.service;

import com.example.tennis.model.Match;
import com.example.tennis.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> findAllMatches(){
        return this.matchRepository.findAll();
    }

    public Match saveMatch(Match match){
        return this.matchRepository.save(match);
    }

}
