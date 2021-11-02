package com.example.tennis.repository;

import com.example.tennis.model.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MatchRepository extends MongoRepository<Match, String> {

    List<Match> findAllByWinner(String id);

    List<Match> findAllByLoser(String id);

}
