package com.example.tennis.service;

import com.example.tennis.model.Match;
import com.example.tennis.model.Player;
import com.example.tennis.model.Tournament;
import com.example.tennis.repository.MatchRepository;
import com.example.tennis.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public int setMatchesWonService(Player player){
        List<Match> matchesWon = matchRepository.findAllByWinner(player.getId());
        return matchesWon.size();
    }

    public int setMatchesLostService(Player player){
        List<Match> matchesPlayed = matchRepository.findAllByLoser(player.getId());
        return matchesPlayed.size();
    }

    public Optional<Player> findById(String id) {
        return this.playerRepository.findById(id);
    }

    public Player savePlayer(Player player){
        return this.playerRepository.save(player);
    }

    public List<Player> findAllPlayers(){
        return this.playerRepository.findAll();
    }

    public List<Player> findPlayersByLevel(int level){
        return this.playerRepository.findByLevel(level);
    }

    public void updateMatchesPlayedAndWon(Match match){
        String idOfWinner = match.getWinner().getId();
        String idOfLoser = match.getLoser().getId();
        Player winner = findById(idOfWinner).orElse(null);
        Player loser = findById(idOfLoser).orElse(null);
        winner.setMatchesWon(setMatchesWonService(match.getWinner()));
        loser.setMatchesWon(setMatchesWonService(match.getLoser()));
        winner.setMatchesPlayed(setMatchesLostService(match.getWinner())+setMatchesWonService(match.getWinner()));
        loser.setMatchesPlayed(setMatchesLostService(match.getLoser())+setMatchesWonService(match.getLoser()));

        playerRepository.save(winner);
        playerRepository.save(loser);
    }

    public List<Player> orderedPlayers(Tournament tournament) {
        List<Player> tournamentPlayers = tournament.getPlayers();
        for(int i=1;i<=tournamentPlayers.size();i++){
            tournamentPlayers.set(i-1, playerRepository.findByTournamentNumber(i).get(0));
        }

        return tournamentPlayers;
    }


}
