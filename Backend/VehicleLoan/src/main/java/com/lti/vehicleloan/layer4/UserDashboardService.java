package com.lti.vehicleloan.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer2.UserDetail;

@Service
public interface UserDashboardService {

	
	List<LoanDetail> selectUserbyUserIdService(int userId);
	
}
