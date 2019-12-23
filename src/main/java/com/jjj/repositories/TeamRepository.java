package com.jjj.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jjj.dto.TeamDto;
import com.jjj.entities.TeamEntity;

@Repository
@Transactional
public class TeamRepository {

	private EntityManager entitymanager;

	public TeamEntity save(TeamEntity team) {
		return entitymanager.merge(team);
	}

	public List<TeamEntity> getAll() {
		Query q = entitymanager.createQuery("from TeamEntity");
		return q.getResultList();
	}

	
	public TeamEntity getTeamById(Integer teamid) {
		return entitymanager.find(TeamEntity.class, teamid);
		
	}
	public TeamEntity getById(Integer Id) {
		return entitymanager.find(TeamEntity.class, Id);
	}

	public EntityManager getEntitymanager() {
		return entitymanager;
	}

	@PersistenceContext
	public void setEntitymanager(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

}
