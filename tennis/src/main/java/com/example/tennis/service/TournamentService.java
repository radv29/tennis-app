package com.example.tennis.service;

import com.example.tennis.model.Player;
import com.example.tennis.model.TourMatch;
import com.example.tennis.model.Tournament;
import com.example.tennis.repository.PlayerRepository;
import com.example.tennis.repository.TourMatchRepository;
import com.example.tennis.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private Tournament tournament;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TourMatchRepository tourMatchRepository;

    public Tournament saveTournament(Tournament tournament){
        this.tournamentRepository.save(tournament);
        List<Integer> drawNumbers = new ArrayList<>();
        for(int i=1;i<=tournament.getNumberOfPlayers();i++){
            drawNumbers.add(i);
            tournament.setNumbersOfOrder(drawNumbers);
        }
        Collections.shuffle(tournament.getNumbersOfOrder());
        return this.tournamentRepository.save(tournament);
    }

    public List<Tournament> findAllTournaments(){
        return tournamentRepository.findAll();
    }

    public Tournament findTournamentByName(String name){
        return this.tournamentRepository.findByName(name);
    }

    public boolean addPlayerToTournament(String tournamentId, String playerId){
        Tournament tournament = tournamentRepository.findById(tournamentId).orElse(null);
        Player player = playerRepository.findById(playerId).orElse(null);
        if(player.getLevel()>tournament.getMaxLevel()){
            return false;
        }else {
            int newNumberOfPlayerRegistered;
            newNumberOfPlayerRegistered = tournament.getPlayersRegistered() + 1;
            tournament.setPlayersRegistered(newNumberOfPlayerRegistered);
            player.setTournamentNumber(tournament.getNumbersOfOrder().get(newNumberOfPlayerRegistered-1));
            playerRepository.save(player);
            List<Player> playersList = tournament.getPlayers();
            playersList.add(player);
            tournament.setPlayers(playersList);
            tournamentRepository.save(tournament);
            if(newNumberOfPlayerRegistered == tournament.getNumberOfPlayers()){
                List<TourMatch> existingMatches = tournament.getMatchesOfTournament();
                existingMatches.addAll(mainDraw(tournament));
                tournament.setMatchesOfTournament(existingMatches);
                tournamentRepository.save(tournament);
            }
            return true;
        }
    }

    public List<TourMatch> mainDraw(Tournament tournament){
        List<TourMatch> tourMatches = new ArrayList<>();
        List<Player> orderedPlayers = playerService.orderedPlayers(tournament);
        for(int i=0;i<orderedPlayers.size();i=i+2){
            TourMatch match = new TourMatch();
            match.setPlayer1(orderedPlayers.get(i));
            match.setPlayer2(orderedPlayers.get(i+1));
            match.setTournamentName(tournament.getName());
            tourMatches.add(match);
            tourMatchRepository.save(match);
        }
        return tourMatches;
    }

}
