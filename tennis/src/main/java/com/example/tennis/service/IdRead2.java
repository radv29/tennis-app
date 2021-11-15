package com.example.tennis.service;

import org.springframework.stereotype.Component;

@Component
public class IdRead2 {

    private String TourMatchId;
    private int playerNumber;
    private int firstPlayersScore;
    private int secondPlayersScore;

    public IdRead2() {
    }

    public String getTourMatchId() {
        return TourMatchId;
    }

    public void setTourMatchId(String tourMatchId) {
        TourMatchId = tourMatchId;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getFirstPlayersScore() {
        return firstPlayersScore;
    }

    public void setFirstPlayersScore(int firstPlayersScore) {
        this.firstPlayersScore = firstPlayersScore;
    }

    public int getSecondPlayersScore() {
        return secondPlayersScore;
    }

    public void setSecondPlayersScore(int secondPlayersScore) {
        this.secondPlayersScore = secondPlayersScore;
    }
}
