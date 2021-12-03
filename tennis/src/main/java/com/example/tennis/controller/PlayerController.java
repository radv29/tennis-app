package com.example.tennis.controller;

import com.example.tennis.dto.PlayerCreationDTO;
import com.example.tennis.dto.PlayerDTO;
import com.example.tennis.mapper.PlayerCreationMapper;
import com.example.tennis.mapper.PlayerMapper;
import com.example.tennis.model.Player;
import com.example.tennis.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerCreationMapper playerCreationMapper;

    @Autowired
    private PlayerMapper playerMapper;

    @PostMapping("/add")
    public void add(@RequestBody PlayerCreationDTO playerCreationDTO){
        Player player = playerCreationMapper.DTOToModel(playerCreationDTO);
        this.playerService.savePlayer(player);
    }

    @GetMapping("/all")
    public List<PlayerDTO> getPlayers(){
        return playerMapper.playersToPlayerDTOs(this.playerService.findAllPlayers());
    }

    @GetMapping("/level{level}")
    public List<PlayerDTO> getByLevel(@PathVariable("level") int level){
        return playerMapper.playersToPlayerDTOs(this.playerService.findPlayersByLevel(level));
    }
}
