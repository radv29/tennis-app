package com.example.tennis.repository;

import com.example.tennis.model.TourMatch;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TourMatchRepository extends MongoRepository<TourMatch, String> {
}
