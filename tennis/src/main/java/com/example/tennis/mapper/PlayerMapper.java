package com.example.tennis.mapper;

import com.example.tennis.dto.PlayerDTO;
import com.example.tennis.model.Player;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

//    PlayerDTO modelToDTO(Player player);
//    Player DTOToModel(PlayerDTO playerDTO);
    List<PlayerDTO> playersToPlayerDTOs(List<Player> players);

}
