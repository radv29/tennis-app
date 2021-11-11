package com.example.tennis.service;

import com.example.tennis.model.TourMatch;
import com.example.tennis.model.Tournament;
import com.example.tennis.repository.TourMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourMatchService {

    @Autowired
    private TourMatchRepository tourMatchRepository;

    @Autowired
    private TournamentService tournamentService;

    public TourMatch saveTourMatch(TourMatch tournamentMatch){
        return this.tourMatchRepository.save(tournamentMatch);
    }

    public List<TourMatch> findAllTournamentMatches(){
        return this.tourMatchRepository.findAll();
    }

    public List<TourMatch> findTourMatchesByTournament(String name){
        Tournament tournaments = tournamentService.findTournamentByName(name);
        return tournaments.getMatchesOfTournament();
    }

}
