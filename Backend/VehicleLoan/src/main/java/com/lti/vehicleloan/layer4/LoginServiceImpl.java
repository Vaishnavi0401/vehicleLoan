package com.lti.vehicleloan.layer4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.Login;
import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer3.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepository;

	public UserDetail validateUser(Login login) {
		if (loginRepository.fetchUser(login) != null)
		{
			return loginRepository.fetchUser(login);
		}
		return null;
	}
}
