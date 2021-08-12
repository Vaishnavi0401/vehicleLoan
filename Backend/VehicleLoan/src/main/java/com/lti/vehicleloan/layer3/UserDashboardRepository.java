package com.lti.vehicleloan.layer3;

import org.springframework.stereotype.Repository;

import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer2.UserNotFoundException;



@Repository
public interface UserDashboardRepository {

	UserDetail selectUserById(int userId) throws UserNotFoundException; 
}
