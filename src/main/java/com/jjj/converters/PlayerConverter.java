package com.jjj.converters;

import com.jjj.dto.PlayerDto;
import com.jjj.entities.PlayerEntity;

public class PlayerConverter {
	
	public static PlayerDto convert(PlayerEntity entity) {
		PlayerDto dto  = null;
		if(entity != null) {
			dto = new PlayerDto();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setPosition(entity.getPosition());
			dto.setAge(entity.getAge());
		}
		return dto;
		
	}

}
