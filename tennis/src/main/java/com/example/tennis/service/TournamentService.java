package com.example.tennis.service;

import com.example.tennis.model.Player;
import com.example.tennis.model.Tournament;
import com.example.tennis.repository.PlayerRepository;
import com.example.tennis.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public Tournament saveTournament(Tournament tournament){
        return this.tournamentRepository.save(tournament);
    }

    public List<Tournament> findAllTournaments(){
        return this.tournamentRepository.findAll();
    }

    public void addPlayerToTournament(String tournamentId, String playerId){
        if(tournamentId == null)
            System.out.println("aeagdag");
        else{
        Tournament tournament = tournamentRepository.findById(tournamentId).orElse(null);
        Player player = playerRepository.findById(playerId).orElse(null);
        List<Player> playersList = new ArrayList<>();
        playersList.add(player);
        tournament.setPlayers(playersList);
        tournamentRepository.save(tournament);
        }
    }

}
