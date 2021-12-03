package com.example.tennis.mapper;

import com.example.tennis.dto.TournamentCreationDTO;
import com.example.tennis.model.Tournament;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TournamentCreationMapper {

    TournamentCreationDTO modelToDTO(Tournament tournament);
    Tournament DTOToModel(TournamentCreationDTO tournamentCreationDTO);

}
