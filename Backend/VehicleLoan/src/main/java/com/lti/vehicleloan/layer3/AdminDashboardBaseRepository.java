package com.lti.vehicleloan.layer3;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AdminDashboardBaseRepository {
	@PersistenceContext
	public EntityManager entityManager;

	public EntityManager getEntityManager() {
		System.out.println("BaseRepository: getting entityManager");
		return entityManager;
	}
}
