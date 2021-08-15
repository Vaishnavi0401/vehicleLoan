package com.lti.vehicleloan.layer3;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.lti.vehicleloan.layer2.Login;
import com.lti.vehicleloan.layer2.UserDetail;

@Repository
public class LoginRepository extends BaseRepository {

	public UserDetail fetchUser(Login login) {
		EntityManager entityManager = super.getEntityManager();
		Query query = entityManager.createQuery(
				"Select user from UserDetail as user where user.email=:emailId and user.password=:password");
		query.setParameter("emailId", login.getEmailId());
		query.setParameter("password", login.getPassword());
		
		if (query.getResultList().size() > 0) {
			return (UserDetail) (query.getResultList().get(0));
		}
		return null;
	}
}
