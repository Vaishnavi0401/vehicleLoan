package com.lti.vehicleloan.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer2.exceptions.UserNotFoundException;



@Repository
public interface UserDashboardRepository {

	
	List<LoanDetail> selectUserById(int userId) throws UserNotFoundException; 
}
