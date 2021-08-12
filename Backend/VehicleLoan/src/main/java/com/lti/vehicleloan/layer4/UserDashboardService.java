package com.lti.vehicleloan.layer4;

import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.UserDetail;

@Service
public interface UserDashboardService {

	UserDetail selectUserbyUserIdService(int userId);
}
