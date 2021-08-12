package com.lti.vehicleloan.layer3;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer2.LoanDetailNotFoundException;
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
	
	
}
