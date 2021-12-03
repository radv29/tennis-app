package com.example.tennis.mapper;

import com.example.tennis.dto.MatchDTO;
import com.example.tennis.model.Match;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MatchMapper {

    MatchDTO modelToDTO(Match match);
    Match DTOToModel(MatchDTO matchDTO);
    List<MatchDTO> matchesToMatchDTOs(List<Match> matches);

}
