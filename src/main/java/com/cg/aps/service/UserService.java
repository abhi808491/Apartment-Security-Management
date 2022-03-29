package com.cg.aps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cg.aps.repository.FlatDAOInt;
import com.cg.aps.repository.GardTraineeDAOInt;
import com.cg.aps.repository.UserDAOInt;
import com.cg.aps.repository.VehicleRepository;
import com.cg.aps.dto.RegisterUserRequest;
import com.cg.aps.entity.FlatEntity;
import com.cg.aps.entity.GardTraineeEntity;
import com.cg.aps.entity.UserEntity;
import com.cg.aps.entity.VehicleEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

@Service
public class UserService implements UserServiceInt{
	
	@Autowired
	UserDAOInt userDao;
	
	@Autowired
	GardTraineeDAOInt gardTraineeDAOInt;
	
	@Autowired
	VehicleRepository vehRepo;
	
	@Autowired
	 FlatDAOInt flatDAOint;
	
	
	@Override
	public long add(UserEntity bean) {
		Optional<UserEntity> user=userDao.findById(bean.getId());
		if(user.isPresent())
		{
			throw new DuplicateRecordException("Record already exist there no duplicate allowed");
		}
		userDao.save(bean);
		return bean.getId();
	}
	
	@Override
	public void update(UserEntity bean) {
		Optional<UserEntity> user=userDao.findById(bean.getId());
		if(!user.isPresent())
		{
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		userDao.save(bean);
		
	}

	@Override
	public void delete(UserEntity bean) {
		Optional<UserEntity> user=userDao.findById(bean.getId());
		if(!user.isPresent())
		{
			throw new RecordNotFoundException("Record not found with given entity details");
		}
			userDao.delete(bean);
	}

	@Override
	public UserEntity findByLogin(String login) {
		UserEntity user=userDao.findByLogin(login);
		if(user==null)
		{
			throw new RecordNotFoundException("Record not found with given login found = " +login);
		}
		return userDao.findByLogin(login);
	}

	@Override
	public UserEntity findByPk(long id) {
		Optional<UserEntity> user=userDao.findById(id);
		if(!user.isPresent())
		{
			throw new RecordNotFoundException("Record not found with given ID =" +id);
		}
		return userDao.getById(id);
	}

	@Override
	public List<UserEntity> search(long pageNo, int pageSize) {
		PageRequest paging = PageRequest.of((int)pageNo,(int) pageSize);
		Page<UserEntity> pagedResult =userDao.findAll(paging);
		if(pagedResult.hasContent())
		{
			return pagedResult.getContent();
		}
		else
		{
			throw new DatabaseException("Database not found");
		}

	}


	
	@Override
	public List<UserEntity> search(UserEntity bean) {
	
			Optional<UserEntity> user = userDao.findById(bean.getId());
			if (!user.isPresent()) {
				throw new RecordNotFoundException("Record not found with given entity details");
			}
			UserEntity newUser = userDao.getById(bean.getId());
			List<UserEntity> al = new ArrayList();
			al.add(newUser);
			return al;
		}

	@Override
	public boolean changePassword(Long id, String oldPassword, String newPassword) {
		Optional<UserEntity> optional = userDao.findById(id);
		if(optional.isPresent()) {
			UserEntity user = optional.get();
			if(user.getPassword().equals(oldPassword)) {
				System.out.println("True");
				user.setPassword(newPassword);
				
				userDao.save(user);
				return true;
			}
			else {
				System.out.println("False");
			}
		}
		return false;
	}

	@Override
	public long registerUser(RegisterUserRequest request) {
		UserEntity user=UserEntity.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.emailId(request.getEmailId())
				.password(request.getPassword()).build();

		UserEntity user1=userDao.save(user);
		return user1.getId();
	}

	@Override
	public boolean forgetPassword(String login) {
		UserEntity user=userDao.findByLogin(login);
		if(user==null)
		{
			throw new RecordNotFoundException("Record not found with given name found in the database = " +login);
		}
		return false;
	}

	@Override
	public UserEntity addGard(long userPk, long gardPk) {
		UserEntity user=userDao.getById(userPk);
		GardTraineeEntity traniee=gardTraineeDAOInt.getById(gardPk);
		user.setGard(traniee);
		userDao.save(user);
		return user;
	
	}
	@Override
	public UserEntity addFlat(long userPk, long flatPk) {
		UserEntity user=userDao.getById(userPk);
		FlatEntity flat=flatDAOint.getById(flatPk);
		 user.setFlat(flat);
		 userDao.save(user);
		return user;
	}
	
	public UserEntity addVehicle(long userPk, long vehiclePk) {
		UserEntity user=userDao.getById(userPk);
		VehicleEntity vehicle=vehRepo.getById(vehiclePk);
		 user.setVehicleEntity(vehicle);
		 userDao.save(user);
		 return user;
}

	}

	


	



	


