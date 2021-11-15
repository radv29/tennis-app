package com.example.tennis.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "Tournament Matches")
public class TourMatch {

    private String id;
    private Player player1;
    private Player player2;
    private Player winner;
    private int player1score;
    private int player2score;
    private String stage;
    private boolean drawn;
    private String tournament;

    public TourMatch() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getPlayer1score() {
        return player1score;
    }

    public void setPlayer1score(int player1score) {
        this.player1score = player1score;
    }

    public int getPlayer2score() {
        return player2score;
    }

    public void setPlayer2score(int player2score) {
        this.player2score = player2score;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public boolean isDrawn() {
        return drawn;
    }

    public void setDrawn(boolean drawn) {
        this.drawn = drawn;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }
}
