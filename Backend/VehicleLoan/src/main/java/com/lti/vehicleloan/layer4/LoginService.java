package com.lti.vehicleloan.layer4;

import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.Login;
import com.lti.vehicleloan.layer2.UserDetail;

@Service
public interface LoginService {
	public UserDetail validateUser(Login login);
}
