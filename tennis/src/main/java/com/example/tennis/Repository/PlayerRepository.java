package com.example.tennis.Repository;

import com.example.tennis.Model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlayerRepository extends MongoRepository<Player, String> {

    List<Player> findByLevel(int level);

}
