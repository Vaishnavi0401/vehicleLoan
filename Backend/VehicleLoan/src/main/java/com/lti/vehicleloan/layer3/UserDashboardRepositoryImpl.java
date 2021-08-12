package com.lti.vehicleloan.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer2.UserNotFoundException;

@Repository
public class UserDashboardRepositoryImpl extends BaseRepository implements UserDashboardRepository {

	@Transactional
	public UserDetail selectUserById(int userId) throws UserNotFoundException {
		
		EntityManager entityManager = getEntityManager();
		return entityManager.find(UserDetail.class, userId);
	}

}
