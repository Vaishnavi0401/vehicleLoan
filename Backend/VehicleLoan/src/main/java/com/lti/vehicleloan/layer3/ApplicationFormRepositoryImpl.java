package com.lti.vehicleloan.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.vehicleloan.layer2.AccountTypeDetail;
import com.lti.vehicleloan.layer2.AddressDetail;
import com.lti.vehicleloan.layer2.CarDetail;
import com.lti.vehicleloan.layer2.CarMaker;
import com.lti.vehicleloan.layer2.CarType;
import com.lti.vehicleloan.layer2.City;
import com.lti.vehicleloan.layer2.EmploymentDetail;
import com.lti.vehicleloan.layer2.State;
import com.lti.vehicleloan.layer2.TypeOfEmploymentDetail;
import com.lti.vehicleloan.layer2.UserDetail;

@Repository
public class ApplicationFormRepositoryImpl extends BaseRepository implements ApplicationFormRepository {

	@Override
	@Transactional
	public Integer insertAddress(AddressDetail add) {
		System.out.println("Repo insert Address called");
		EntityManager entityManager = super.getEntityManager();
		entityManager.persist(add);
		System.out.println("Address Successfully added: "+add.getAddressId());
		return add.getAddressId();
	}

	@Override
	@Transactional
	public Integer insertUser(UserDetail user) {
		System.out.println("Repo insert User details called");
		EntityManager entityManager = super.getEntityManager();
		entityManager.persist(user);
		System.out.println("User Successfully added: "+user.getUserId());
		return user.getUserId();
	}
	

	@Override
	public List<UserDetail> selectAllUsers() {
		EntityManager entityManager = super.getEntityManager();
		Query query = entityManager.createQuery("from UserDetail");
		return query.getResultList();
	}

	
	@Override
	public AddressDetail selectAddress(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City selectCity(String cityId) {
		EntityManager entityManager = super.getEntityManager();
		return entityManager.find(City.class, cityId);
	}

	@Override
	public State selectState(String stateId) {
		EntityManager entityManager = super.getEntityManager();
		return entityManager.find(State.class, stateId);
	}

	@Override
	public List<City> selectAllCities() {
		System.out.println("Repo select all Cities called");
		EntityManager entityManager = super.getEntityManager();
		Query query = entityManager.createQuery("from City");
		return query.getResultList();
	}

	@Override
	public List<State> selectAllStates() {
		System.out.println("Repo select all State called");
		EntityManager entityManager = super.getEntityManager();
		Query query = entityManager.createQuery("from State");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void updateAddress(UserDetail user, Integer addressId) {
		EntityManager entityManager = super.getEntityManager();
		AddressDetail add = entityManager.find(AddressDetail.class, addressId);
		user.setAddressDetail(add);
		entityManager.merge(user);
//		Query query = entityManager.createQuery("update UserDetail as u set u.addressDetail=:addressId where u.userId=:userId");
//		query.setParameter("addressId", addressId);
//		query.setParameter("userId", user.getUserId());
//		query.executeUpdate();
//		System.out.println("address successfully updated");
//		return query.getResultList();
	}

	@Override
	public List<CarDetail> selectAllCars() {
		EntityManager entityManager = super.getEntityManager();
		Query query = entityManager.createQuery("from CarDetail");
		return query.getResultList();
	}

	@Override
	@Transactional
	public Integer insertCar(CarDetail car) {
		System.out.println("Insert car Repo called");
		EntityManager entityManager = super.getEntityManager();
		entityManager.persist(car);
		System.out.println("Car Successfully added: "+car.getCarId());
		return car.getCarId();	
	}

	@Override
	@Transactional
	public Integer insertCarMaker(CarMaker carMaker) {
		System.out.println("Insert Car Maker called");
		EntityManager entityManager = super.getEntityManager();
		entityManager.persist(carMaker);
		System.out.println("Car Maker Successfully added: "+carMaker.getCarMakerId());
		return carMaker.getCarMakerId();
	}

	@Override
	public List<CarMaker> selectAllCarMakers() {
		EntityManager entityManager = super.getEntityManager();
		Query query = entityManager.createQuery("from CarMaker");
		return query.getResultList();
	}

	@Override
	public List<CarType> selectAllCarTypes() {
		EntityManager entityManager = super.getEntityManager();
		Query query = entityManager.createQuery("from CarType");
		return query.getResultList();
	}

	@Override
	public List<TypeOfEmploymentDetail> selectAllTypeOfEmployments() {
		System.out.println("Repo select all Type of Employment Detail called");
		EntityManager entityManager = super.getEntityManager();
		Query query = entityManager.createQuery("from TypeOfEmploymentDetail");
		return query.getResultList();
	}

	@Override
	public List<AccountTypeDetail> selectAllAccountTypeDetails() {
		System.out.println("Repo select all Account Type Detail called");
		EntityManager entityManager = super.getEntityManager();
		Query query = entityManager.createQuery("from AccountTypeDetail");
		return query.getResultList();
	}

	@Override
	@Transactional
	public Integer insertEmploymentDetail(EmploymentDetail employmentDetail) {
		System.out.println("Repo insert User details called");
		EntityManager entityManager = super.getEntityManager();
		entityManager.persist(employmentDetail);
		return employmentDetail.getEmployeeId();
	}



}
