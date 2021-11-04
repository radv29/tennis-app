package com.example.tennis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Matches")
public class Match {

    @Id
    private String id;
    @DBRef
    private Player winner;
    @DBRef
    private Player loser;
    private int winnersScore;
    private int losersScore;

    public Match() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getLoser() {
        return loser;
    }

    public void setLoser(Player loser) {
        this.loser = loser;
    }

    public int getWinnersScore() {
        return winnersScore;
    }

    public void setWinnersScore(int winnersScore) {
        this.winnersScore = winnersScore;
    }

    public int getLosersScore() {
        return losersScore;
    }

    public void setLosersScore(int losersScore) {
        this.losersScore = losersScore;
    }
}
