package com.example.tennis.dto;

import com.example.tennis.model.Player;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class MatchDTO {

    private String id;
    @DBRef
    private Player winner;
    @DBRef
    private Player loser;
    private int winnersScore;
    private int losersScore;

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
