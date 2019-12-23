package com.jjj.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjj.dto.TeamDto;
import com.jjj.entities.TeamEntity;
import com.jjj.repositories.TeamRepository;

@Service
public class TeamService {
	@Autowired
	private TeamRepository teamrepository;

//	public void createTeam(TeamDto dto) {
//
//		TeamEntity team = new TeamEntity();
//
//		team.setName(dto.getName());
//		team.setCountry(dto.getCountry());
//		team.setManager(dto.getManager());
//		team.setLogo(dto.getLogo());
//		team.setUpdatedat(new Date());
//		team.setCreatedat(new Date());
//
//		teamrepository.save(team);
//	}

	public TeamDto createTeam(TeamDto dto) {

		TeamEntity team = new TeamEntity();

		team.setName(dto.getName());
		team.setCountry(dto.getCountry());
		team.setManager(dto.getManager());
		team.setLogo(dto.getLogo());
		team.setUpdatedat(new Date());
		team.setCreatedat(new Date());

		return convert(teamrepository.save(team));

	}

	public List<TeamDto> getAllTeam() {

		List<TeamEntity> team = teamrepository.getAll();

		List<TeamDto> returnlist = new ArrayList<TeamDto>();
		for (TeamEntity t : team) {
			TeamDto d = convert(t);
			returnlist.add(d);
		}
		return returnlist;

	}

	public TeamDto getTeamByTeamid(Integer teamid) {
		TeamEntity team = teamrepository.getById(teamid);
		TeamDto d = convert(team);
		return d;
	}

	private TeamDto convert(TeamEntity teamentity) {

		TeamDto dto = null;
		if (teamentity != null) {
			dto = new TeamDto();
			dto.setId(teamentity.getTeamid());
			dto.setName(teamentity.getCountry());
			dto.setManager(teamentity.getManager());
			dto.setLogo(teamentity.getLogo());
			dto.setCountry(teamentity.getCountry());
		}

		return dto;
	}
}
