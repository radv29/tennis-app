package com.example.tennis.service;

import org.springframework.stereotype.Component;

@Component
public class IdRead {

    private String TournamentId;
    private String PlayerId;

    public IdRead() {
    }

    public String getTournamentId() {
        return TournamentId;
    }

    public void setTournamentId(String tournamentId) {
        TournamentId = tournamentId;
    }

    public String getPlayerId() {
        return PlayerId;
    }

    public void setPlayerId(String playerId) {
        PlayerId = playerId;
    }
}
