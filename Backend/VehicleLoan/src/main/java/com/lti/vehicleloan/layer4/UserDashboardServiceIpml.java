package com.lti.vehicleloan.layer4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer2.UserNotFoundException;
import com.lti.vehicleloan.layer3.UserDashboardRepositoryImpl;

@Service
public class UserDashboardServiceIpml implements UserDashboardService {

	@Autowired
	
	UserDashboardRepositoryImpl userRepo;
	
	@Override
	public UserDetail selectUserbyUserIdService(int userId) {
		

		try {
			return userRepo.selectUserById(userId);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		
		return null;
	}

}
