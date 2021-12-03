package com.example.tennis.mapper;

import com.example.tennis.dto.PlayerCreationDTO;
import com.example.tennis.model.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerCreationMapper {

    PlayerCreationDTO modelToDTO(Player player);
    Player DTOToModel(PlayerCreationDTO playerCreationDTO);

}
