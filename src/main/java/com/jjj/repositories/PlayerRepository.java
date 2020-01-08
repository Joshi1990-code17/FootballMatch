package com.jjj.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jjj.entities.PlayerEntity;

@Repository
@Transactional
public class PlayerRepository {

	private EntityManager entityManager;

	public PlayerEntity save(PlayerEntity player) {
		return entityManager.merge(player);
	}

	public List<PlayerEntity> getAll() {
		Query q = entityManager.createQuery("from PlayerEntity");
		return q.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
