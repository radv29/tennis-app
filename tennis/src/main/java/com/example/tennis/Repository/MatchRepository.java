package com.example.tennis.Repository;

import com.example.tennis.Model.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MatchRepository extends MongoRepository<Match, String> {

    List<Match> findAllByWinner(String id);

    List<Match> findAllByLoser(String id);

}
