package com.example.tennis.mapper;

import com.example.tennis.dto.TournamentDTO;
import com.example.tennis.model.Tournament;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TournamentMapper {

    List<TournamentDTO> tournamentsToTournamentDTOs(List<Tournament> tournaments);
    TournamentDTO tournamentToTournamentDTO(Tournament tournament);
    Tournament tournamentDTOToTournament(TournamentDTO tournamentDTO);

}
