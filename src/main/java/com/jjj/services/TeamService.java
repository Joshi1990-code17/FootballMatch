package com.jjj.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjj.dto.TeamDto;
import com.jjj.entities.TeamEntity;
import com.jjj.repositories.TeamRepository;

@Service
public class TeamService {
	@Autowired
	private TeamRepository teamrepository;

	public void createTeam(TeamDto dto) {

		TeamEntity team = new TeamEntity();

		team.setName(dto.getName());
		team.setCountry(dto.getCountry());
		team.setManager(dto.getManager());
		team.setLogo(dto.getLogo());
		team.setUpdatedat(new Date());
		team.setCreatedat(new Date());

		teamrepository.save(team);
	}
}
