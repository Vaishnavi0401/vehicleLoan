package com.lti.vehicleloan.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.vehicleloan.layer2.AddressDetail;
import com.lti.vehicleloan.layer2.CarDetail;
import com.lti.vehicleloan.layer2.CarMaker;
import com.lti.vehicleloan.layer2.CarType;
import com.lti.vehicleloan.layer2.City;
import com.lti.vehicleloan.layer2.State;
import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer4.ApplicationFormServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/appForm")
public class ApplicationFormController {

	@Autowired
	ApplicationFormServiceImpl appFormService;
	
	
//	@PostMapping
//	@ResponseBody
//	@RequestMapping(value="/addAddress")
//	public String addAddress(@RequestBody AddressDetail add) {
//		appFormService.insertAddressService(add);
//		return "Address Added Successfully";
//	}
	
	@PostMapping
	@ResponseBody
	@RequestMapping(value="/addUser")
	public String addUser(@RequestBody UserDetail user) {
		appFormService.insertUserService(user);
		return "{\"status\" : \"User Added Successfully\"}";
	}
	
	@PostMapping
	@ResponseBody
	@RequestMapping(value="/addCar")
	public String addUser(@RequestBody CarDetail car) {
		appFormService.insertCarService(car);
		return "{\"status\" : \"Car Added Successfully\"}";
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getAllUsers")
	public List<UserDetail> getUsers() {
		return appFormService.selectAllUsersService();
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getAllCities")
	public List<City> getCities() {
		return appFormService.selectAllCityService();
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getAllStates")
	public List<State> getStates() {
		return appFormService.selectAllStateService();
	}


	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getAllCars")
	public List<CarDetail> getCars() {
		return appFormService.selectAllCarsService();
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getAllCarMakers")
	public List<CarMaker> getCarMakers() {
		return appFormService.selectAllCarMakerService();
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getAllCarTypes")
	public List<CarType> getCarTypes() {
		return appFormService.selectAllCarTypeService();
	}
	
}
