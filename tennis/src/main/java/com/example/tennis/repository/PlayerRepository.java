package com.example.tennis.repository;

import com.example.tennis.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlayerRepository extends MongoRepository<Player, String> {

    List<Player> findByLevel(int level);

    List<Player> findByTournamentNumber(int tournamentNumber);

}
