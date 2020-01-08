package com.jjj.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjj.dto.PlayerDto;
import com.jjj.entities.PlayerEntity;
import com.jjj.entities.TeamEntity;
import com.jjj.repositories.PlayerRepository;
import com.jjj.repositories.TeamRepository;

@Service
public class PlayerService {

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private PlayerRepository playerRepository;

	public void createPlayer(Integer id, PlayerDto dto) throws Exception {
		TeamEntity team = teamRepository.getById(id);
		if (team == null) {
			throw new Exception("Team does not exist :" + id);
		} else {
			PlayerEntity p = convert(dto);
			p.setTeam(team);
			if (p != null) {
				playerRepository.save(p);
			}
		}
	}

	private PlayerEntity convert(PlayerDto dto) {
		PlayerEntity p = null;
		if (dto != null) {
			p = new PlayerEntity();
			p.setName(dto.getName());
			p.setPosition(dto.getPosition());
			p.setAge(dto.getAge());
		}
		return p;
	}

	public List<PlayerDto> getAllplayer() {

		List<PlayerEntity> players = playerRepository.getAll();

		List<PlayerDto> returnlist = new ArrayList<PlayerDto>();
		for (PlayerEntity P : players) {
			PlayerDto d = convert(P);
			returnlist.add(d);
		}
		return returnlist;
	}

	private PlayerDto convert(PlayerEntity playerEntity) {
		PlayerDto p = null;
		if (playerEntity != null) {
			p = new PlayerDto();
			p.setId(playerEntity.getId());
			p.setName(playerEntity.getName());
			p.setPosition(playerEntity.getPosition());
			p.setAge(playerEntity.getAge());
		}
		return p;
	}
}