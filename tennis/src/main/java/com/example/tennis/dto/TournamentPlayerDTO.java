package com.example.tennis.dto;

public class TournamentPlayerDTO {

    private String TournamentId;
    private String PlayerId;

    public TournamentPlayerDTO() {
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
