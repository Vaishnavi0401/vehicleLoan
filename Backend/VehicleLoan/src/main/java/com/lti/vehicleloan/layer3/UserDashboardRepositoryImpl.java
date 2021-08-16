package com.lti.vehicleloan.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer2.exceptions.UserNotFoundException;

@Repository
public class UserDashboardRepositoryImpl extends BaseRepository implements UserDashboardRepository {
	

	@Transactional
	public List<LoanDetail> selectUserById(int userId) throws UserNotFoundException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select loan from UserDetail user, LoanDetail loan where user.userId = loan.userDetail.userId and user.userId = :duserId");
		query.setParameter("duserId", userId);
		List<LoanDetail> loans = query.getResultList();
		return loans;
	}

}
