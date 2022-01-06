package com.example.tennis.controller;

import com.example.tennis.dto.PlayerCreationDTO;
import com.example.tennis.dto.PlayerDTO;
import com.example.tennis.mapper.PlayerCreationMapper;
import com.example.tennis.mapper.PlayerMapper;
import com.example.tennis.model.Player;
import com.example.tennis.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerCreationMapper playerCreationMapper;

    @Autowired
    private PlayerMapper playerMapper;

    @PostMapping("/add")
    public String add(@ModelAttribute("player") PlayerCreationDTO playerCreationDTO, BindingResult bindingResult){
        Player player = playerCreationMapper.DTOToModel(playerCreationDTO);
        this.playerService.savePlayer(player);
        return "players";
    }

    @GetMapping("/add")
    public String addView(Model model){
        model.addAttribute("player", new PlayerCreationDTO());
        return "addPlayer";
    }

    @GetMapping("/all")
    public String getPlayers(Model model){
        List<PlayerDTO> playersList = new ArrayList<>();
        playersList = playerMapper.playersToPlayerDTOs(this.playerService.findAllPlayers());
        model.addAttribute("players", playersList);
        return "players";
    }

    @GetMapping("/level{level}")
    public String getByLevel(@PathVariable("level") int level, Model model){
        List<PlayerDTO> playersList = new ArrayList<>();
        playersList = playerMapper.playersToPlayerDTOs(this.playerService.findPlayersByLevel(level));
        model.addAttribute("players", playersList);
        return "players";
    }

    @GetMapping("/{playerId}")
    public String getPlayer(@PathVariable("playerId") String playerId, Model model){
        Player player = playerService.findById(playerId).orElse(null);
        PlayerDTO playerDTO = playerMapper.playerToPlayerDTO(player);
        model.addAttribute("player", playerDTO);
        return "playerPage";
    }
}
