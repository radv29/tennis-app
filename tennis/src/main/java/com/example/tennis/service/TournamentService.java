package com.example.tennis.service;

import com.example.tennis.model.Player;
import com.example.tennis.model.TourMatch;
import com.example.tennis.model.Tournament;
import com.example.tennis.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TourMatchService tourMatchService;

    public Tournament saveTournament(Tournament tournament){
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
        Player player = playerService.findById(playerId).orElse(null);

        if(player.getLevel()>tournament.getMaxLevel()){
            return false;
        }else {

            tournament.setPlayersRegistered(tournament.getPlayersRegistered() + 1);

            List<Player> playersList = tournament.getPlayers();
            playersList.add(player);
            tournament.setPlayers(playersList);
            tournamentRepository.save(tournament);

            if(tournament.getPlayersRegistered() == tournament.getMaxPlayers()){
                List<TourMatch> existingMatches = tournament.getMatchesOfTournament();
                existingMatches.addAll(tourMatchService.mainDraw(tournament));
                tournament.setMatchesOfTournament(existingMatches);
                tournamentRepository.save(tournament);
            }

            return true;
        }
    }

}
