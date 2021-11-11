package com.example.tennis.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Document(collection = "Tournaments")
public class Tournament {

    private String id;
    private String name;
    private int numberOfPlayers;
    private int maxLevel;
    List<Integer>numbersOfOrder = new ArrayList<>();
    private int playersRegistered;
    @DBRef
    private List<Player> players = new ArrayList<>();
    @DBRef
    private List<TourMatch> matchesOfTournament = new ArrayList<>();

    public Tournament() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public List<Integer> getNumbersOfOrder() {
        return numbersOfOrder;
    }

    public void setNumbersOfOrder(List<Integer> numbersOfOrder) {
        this.numbersOfOrder = numbersOfOrder;
    }

    public int getPlayersRegistered() {
        return playersRegistered;
    }

    public void setPlayersRegistered(int playersRegistered) {
        this.playersRegistered = playersRegistered;
    }

        public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<TourMatch> getMatchesOfTournament() {
        return matchesOfTournament;
    }

    public void setMatchesOfTournament(List<TourMatch> matches) {
        this.matchesOfTournament = matchesOfTournament;
    }
}
