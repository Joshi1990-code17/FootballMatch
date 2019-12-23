package com.jjj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jjj.dto.PlayerDto;
import com.jjj.services.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void addPlayer(@RequestParam(value = "teamid") Integer teamid, @RequestBody PlayerDto playerDto)
			throws Exception {
		playerService.createPlayer(teamid, playerDto);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<PlayerDto> getAllPlayers(@RequestParam(required = false) Integer teamid) {
		return playerService.getAllplayer();
	}
}
