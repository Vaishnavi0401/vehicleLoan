package com.lti.vehicleloan.layer3;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.lti.vehicleloan.layer2.AdvancedUserDetail;
import com.lti.vehicleloan.layer2.EmploymentDetail;
import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer2.exceptions.AdvancedUserDetailNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.EmploymentDetailNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.LoanDetailNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.UserDetailNotFoundException;
@Repository
public class AdminDashboardRepositoryImpl extends AdminDashboardBaseRepository implements AdminDashboardRepository{

	public AdminDashboardRepositoryImpl() {
		System.out.println("Admin Dashboard Repository Impl() constructed..");
	}
	@Transactional
	public List<LoanDetail> selectAllLoanDetails() {
		// TODO Auto-generated method stub
		System.out.println("Admin Dashboard Repository Impl: Layer 3");
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("from LoanDetail ");
		List<LoanDetail> loanDetailList=query.getResultList();
		return loanDetailList;
		
//		System.out.println("Loan Detail list: "+loanDetailList.size());	
//		for(LoanDetail loanDetail: loanDetailList) {
//			System.out.println("");
//		}
		
	}
	@Transactional
	@Modifying
	
	public void updateApproval(LoanDetail loanDetail) throws LoanDetailNotFoundException {

		EntityManager entityManager=getEntityManager();
		int loanId=loanDetail.getLoanId();
		String approval=loanDetail.getApproval();
		
		Query query=entityManager.createQuery("update LoanDetail l set l.approval=:approval where l.loanId=:loanId");
		query.setParameter("approval",approval );
		query.setParameter("loanId",loanId);
		query.executeUpdate();
		System.out.println("Loan Details Updated....");
		
		
	}
	
	@Transactional
	public void deleteLoanDetail(int loanId) throws LoanDetailNotFoundException {

		EntityManager entityManager=getEntityManager();
		LoanDetail foundLoanDetail=entityManager.find(LoanDetail.class, loanId );
		entityManager.remove(foundLoanDetail);
		System.out.println("Loan detail removed..");

		
	}
	
	@Transactional
	public LoanDetail selectLoanDetailbyloanId(int loanId) throws LoanDetailNotFoundException {

		EntityManager entityManager = getEntityManager();

		return entityManager.find(LoanDetail.class, loanId);
	}
	
	@Transactional
	public List<LoanDetail> selectLoanDetailbyApproval(String approval) throws LoanDetailNotFoundException {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select l from LoanDetail l where l.approval=:approval");
		query.setParameter("approval", approval);
		List<LoanDetail> loanDetailListByApproval=query.getResultList();
		return loanDetailListByApproval;	
	}
	
	@Transactional
	public List<AdvancedUserDetail> selectAllAdvancedUserDetail() {

		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("from AdvancedUserDetail");
		List<AdvancedUserDetail> advancedUserDetailList=query.getResultList();
		return advancedUserDetailList;
	}
	
	@Transactional
	public UserDetail getUserDetailByUserId(int userId) throws UserDetailNotFoundException {
		
		EntityManager entityManager=getEntityManager();
		return entityManager.find(UserDetail.class, userId);
		
	}
	@Transactional
	public AdvancedUserDetail selectAdvancedUserDetailByUserId(int userId) throws AdvancedUserDetailNotFoundException {
		
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select adv from AdvancedUserDetail adv , UserDetail ud where ud.userId=:userId");
		query.setParameter("userId", userId);
		AdvancedUserDetail advancedUserDetail=(AdvancedUserDetail) query.getSingleResult();
		return advancedUserDetail;
	}
	
	//Query query=entityManager.createQuery("select l,adv from AdvancedUserDetail adv , UserDetail ud, LoanDetail l where ud.userId=:userId");

//	EntityManager entityManager = getEntityManager();
//	Query query = entityManager.createQuery("select loan from UserDetail user, LoanDetail loan where user.userId = loan.userDetail.userId and user.userId = :duserId");
//	query.setParameter("duserId", userId);
//	List<UserDetail> users = query.getResultList();
//	return users;
	//
	
	@Transactional
	public List<UserDetail> getUserDetailsByLoanId(int loanId) {

		EntityManager entityManager = getEntityManager();
		//Query query = entityManager.createQuery("select user from UserDetail user,LoanDetail l where l.userId: ");
		return null;
	}

	@Transactional
	public AdvancedUserDetail selectAdvancedUserDetailByLoanId(int loanId) throws AdvancedUserDetailNotFoundException {
		
		EntityManager entityManager = getEntityManager();
		LoanDetail foundLoanDetail=entityManager.find(LoanDetail.class, loanId );
		int foundLoanDetailUserId=foundLoanDetail.getUserDetail().getUserId();	
		//Query query = entityManager.createQuery("select adv from AdvancedUserDetail adv , UserDetail ud where ud.userId=:userId  ");
		Query query = entityManager.createQuery("select adv from AdvancedUserDetail adv , UserDetail ud where adv.userDetail.userId=ud.userId and ud.userId=:userId");
		query.setParameter("userId",foundLoanDetailUserId );
		AdvancedUserDetail advancedUserDetail=(AdvancedUserDetail) query.getSingleResult();
		return advancedUserDetail;
	}
	
	
	@Transactional
	public List<EmploymentDetail> getEmploymentDetailsByLoanId(int loanId) throws EmploymentDetailNotFoundException {
		EntityManager entityManager = getEntityManager();
		LoanDetail foundLoanDetail=entityManager.find(LoanDetail.class, loanId );
		int foundLoanDetailUserId=foundLoanDetail.getUserDetail().getUserId();	
		//Query query = entityManager.createQuery("select ed from EmploymentDetail ed, UserDetail ud where ud.userId=:userId and ed.userDetail.userId=:userId "); 
		Query query = entityManager.createQuery("select ed from EmploymentDetail ed, UserDetail ud where ed.userDetail.userId=ud.userId and ud.userId=:userId");
		query.setParameter("userId", foundLoanDetailUserId );
		List<EmploymentDetail> employmentDetail=query.getResultList();
		return employmentDetail;
	}
	
	
	
	
	
	
	
	
	
	
}


