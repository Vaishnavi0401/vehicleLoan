package com.lti.vehicleloan.layer4;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lti.vehicleloan.layer2.AccountTypeDetail;
import com.lti.vehicleloan.layer2.AddressDetail;
import com.lti.vehicleloan.layer2.AdvancedUserDetail;
import com.lti.vehicleloan.layer2.ApplicationFormDto;
import com.lti.vehicleloan.layer2.CarDetail;
import com.lti.vehicleloan.layer2.CarMaker;
import com.lti.vehicleloan.layer2.CarType;
import com.lti.vehicleloan.layer2.City;
import com.lti.vehicleloan.layer2.EmploymentDetail;
import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer2.State;
import com.lti.vehicleloan.layer2.TypeOfEmploymentDetail;
import com.lti.vehicleloan.layer2.UserDetail;

@Service
public interface ApplicationFormService {

	Integer insertAddressService(AddressDetail add);
	void updateAddressService(UserDetail user, Integer addressId);
	
	Integer insertUserService(UserDetail user);
	List<UserDetail> selectAllUsersService();
	
	Integer insertCarService(CarDetail car);
	Integer insertCarMakerService(CarMaker carMaker);
	List<CarMaker> selectAllCarMakerService();
	List<CarType> selectAllCarTypeService();
	List<CarDetail> selectAllCarsService();
	
	List<City> selectAllCityService();
	List<State> selectAllStateService();
	
	List<TypeOfEmploymentDetail> selectAllTypeOfEmploymentService();
	List<AccountTypeDetail> selectAllAccountTypeDetailService();
	Integer insertEmploymentDetailService(EmploymentDetail employmentDetail);
	
	Integer insertLoanDetailService(LoanDetail loanDetail);
	
	Integer insertAdvancedUserDetailService(AdvancedUserDetail advancedUserDetail);
	
	
	String insertApplicationFormService(ApplicationFormDto applicationForm);
	
}
