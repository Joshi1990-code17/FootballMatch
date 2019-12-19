package com.jjj.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jjj.entities.TeamEntity;

@Repository
public class TeamRepository {

	private EntityManager entitymanager;

	@Transactional
	public void save(TeamEntity team) {
		entitymanager.persist(team);
	}

	public EntityManager getEntitymanager() {
		return entitymanager;
	}

	@PersistenceContext
	public void setEntitymanager(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

}
