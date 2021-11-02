package com.example.tennis.controller;

import com.example.tennis.model.Player;
import com.example.tennis.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping("/add")
    public void add(@RequestBody Player player){
        this.playerRepository.save(player);
    }

    @GetMapping("/all")
    public List<Player> getPlayers(){
        return this.playerRepository.findAll();
    }

    @GetMapping("/level{level}")
    public List<Player> getByLevel(@PathVariable("level") int level){
        return this.playerRepository.findByLevel(level);
    }
}
