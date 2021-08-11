package com.lti.vehicleloan.layer3;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class BaseRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		System.out.println("BaseRepository: getting entityManagerFactory");
		return entityManager;
	}
}
