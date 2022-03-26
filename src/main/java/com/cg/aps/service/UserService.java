package com.cg.aps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.cg.aps.repository.UserDAOInt;

import com.cg.aps.dto.request.RegisterUserRequest;
import com.cg.aps.entity.UserEntity;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

@Service
public class UserService implements UserServiceInt{
	
	@Autowired
	UserDAOInt userDao;
	Logger logger = LoggerFactory.getLogger(UserService.class);
	@Override
	public long add(UserEntity bean) {
		Optional<UserEntity> user=userDao.findById(bean.getId());
		if(user.isPresent())
		{
			throw new DuplicateRecordException("Record is already exist there no duplicate allowed");
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
			throw new RecordNotFoundException("Record not found with given name found in the database = " +login);
		}
		return userDao.findByLogin(login);
	}

	@Override
	public UserEntity findByPk(long id) {
		Optional<UserEntity> user=userDao.findById(id);
		if(!user.isPresent())
		{
			throw new RecordNotFoundException("Record not found with given Id =" +id);
		}
		return userDao.getById(id);
	}

	@Override
	public List<UserEntity> search(UserEntity bean, long pageNo, int pageSize) {
		PageRequest paging = PageRequest.of((int)pageNo,(int) pageSize);
		Page<UserEntity> pagedResult =userDao.findAll(paging);
		return pagedResult.getContent();
	}



		@Override
	public UserEntity authenticate(UserEntity bean) {
			Optional<UserEntity> user = userDao.findById(bean.getId());
			if(user.isPresent()) {
				UserEntity temp = user.get();
				if(temp.getPassword()==bean.getPassword()) {
					return temp;
				}
			}
			return (UserEntity) userDao.getById(bean.getId());
		
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
		System.out.println(user1.getId());
		logger.info("Id {}",user1.getId());

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

	}

	


	



	


