package com.example.tennis.controller;

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

    @PostMapping("/add")
    public void add(@RequestBody Player player){
        this.playerService.savePlayer(player);
    }

    @GetMapping("/all")
    public List<Player> getPlayers(){
        return this.playerService.findAllPlayers();
    }

    @GetMapping("/level{level}")
    public List<Player> getByLevel(@PathVariable("level") int level){
        return this.playerService.findPlayersByLevel(level);
    }
}
