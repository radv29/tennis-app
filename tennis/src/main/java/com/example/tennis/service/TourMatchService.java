package com.example.tennis.service;

import com.example.tennis.model.Player;
import com.example.tennis.model.TourMatch;
import com.example.tennis.model.Tournament;
import com.example.tennis.repository.TourMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourMatchService {

    @Autowired
    private TourMatchRepository tourMatchRepository;

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private PlayerService playerService;

    public TourMatch saveTourMatch(TourMatch tournamentMatch){
        return this.tourMatchRepository.save(tournamentMatch);
    }

    public List<TourMatch> findAllTournamentMatches(){
        return this.tourMatchRepository.findAll();
    }

    public List<TourMatch> findTourMatchesByTournamentId(String tournamentId){
        Tournament tournament = tournamentService.findTournamentById(tournamentId);
        return tournament.getMatchesOfTournament();
    }

    public List<TourMatch> findTourMatchesByTournament(String name){
        Tournament tournaments = tournamentService.findTournamentByName(name);
        return tournaments.getMatchesOfTournament();
    }

    public List<TourMatch> mainDraw(Tournament tournament){

        List<TourMatch> tourMatches = new ArrayList<>();
        List<Player> orderedPlayers = playerService.orderPlayers(tournament);

        for(int i=0;i<orderedPlayers.size();i=i+2){

            TourMatch match = new TourMatch();
            match.setPlayer1(orderedPlayers.get(i));
            match.setPlayer2(orderedPlayers.get(i+1));
            match.setTournament(tournament.getName());
            match.setStage("1st Round");
            match.setDrawn(false);
            tourMatches.add(match);
            tourMatchRepository.save(match);

        }
        return tourMatches;
    }

    public boolean updateMatchWinner(String tourMatchId, int playerNumber, int firstPlayersScore, int secondPlayersScore) {

        TourMatch tourMatch = tourMatchRepository.findById(tourMatchId).orElse(null);

        tourMatch.setPlayer1score(firstPlayersScore);
        tourMatch.setPlayer2score(secondPlayersScore);
        tourMatch.setTournament(tourMatch.getTournament());

        if (playerNumber == 1) {
            tourMatch.setWinner(tourMatch.getPlayer1());
            if(firstPlayersScore<=secondPlayersScore){
                return false;
            }
        } else {
            tourMatch.setWinner(tourMatch.getPlayer2());
            if(secondPlayersScore<=firstPlayersScore){
                return false;
            }
        }
        tourMatchRepository.save(tourMatch);
        return true;
    }

    public void drawMatches(Tournament tournament){

        List<TourMatch> tourMatches = tournament.getMatchesOfTournament();
        int n = tourMatches.size();

        for(int i=0; i<n; i=i+2) {

            if(!tourMatches.get(i).isDrawn()) {

                TourMatch match = new TourMatch();
                match.setPlayer1(tourMatches.get(i).getWinner());
                match.setPlayer2(tourMatches.get(i + 1).getWinner());
                tourMatches.add(match);
                tourMatchRepository.save(match);
            }
        }

        for(int i=0;i<n;i++){
            tourMatches.get(i).setDrawn(true);
            tourMatchRepository.save(tourMatches.get(i));
        }

        tournament.setMatchesOfTournament(tourMatches);
        tournamentService.saveTournament(tournament);
    }

}
