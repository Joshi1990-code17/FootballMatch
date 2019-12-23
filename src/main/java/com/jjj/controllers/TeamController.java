package com.jjj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jjj.dto.TeamDto;
import com.jjj.entities.TeamEntity;
import com.jjj.services.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamservice;

//	@RequestMapping(value="",method =RequestMethod.POST)
//	public void createTeam(@RequestBody TeamDto dto) {
//		teamservice.createTeam(dto);
//	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public TeamDto GetDto(@RequestBody TeamDto dto) {
		return teamservice.createTeam(dto);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<TeamDto> getAllTeams(@RequestParam(required = false) Integer teamid, @RequestBody TeamDto teamDto) {
		return teamservice.getAllTeam();
	}

	@RequestMapping(value = "/teamid/{teamid}", method = RequestMethod.GET)
	public TeamDto getPlayersDtoByTeamId(@PathVariable Integer teamid) {
		return teamservice.getTeamByTeamid(teamid);
	}

}

//@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
//public TeamDto getTeamById(@PathVariable Long id) {
//	return teamService.getTeamByID(id);
//}