package com.example.tennis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisApplication {

//	@Autowired
//	private Player player;
//
//	@Autowired
//	private static PlayerRepository playerRepository;
//
//	@Autowired
//	private static PlayerService playerService;

	public static void main(String[] args) {

		SpringApplication.run(TennisApplication.class, args);

//		playerRepository.findAll().forEach(player1 -> player1.setMatchesWon(playerService.setMatchesWon(player1)));

	}

}
