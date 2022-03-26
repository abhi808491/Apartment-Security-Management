package com.cg.aps.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.aps.dto.request.RegisterUserRequest;
import com.cg.aps.entity.UserEntity;
import com.cg.aps.repository.UserDAOInt;



public interface UserServiceInt {
	

		public long add(UserEntity bean);
		
		public void update(UserEntity bean);
		
		public void delete(UserEntity bean);
		
		public UserEntity findByLogin(String login);
		
		public UserEntity findByPk(long id);
		
		public List<UserEntity> search(UserEntity bean, long pageNo, int pageSize);
		
		public List<UserEntity> search(UserEntity bean);
		
		public UserEntity authenticate(UserEntity bean);
		
		public boolean changePassword(Long id, String oldPassword,
	            String newPassword) ;
	    

	    public long registerUser(RegisterUserRequest request);
	    
	    public boolean forgetPassword(String login);

	
		
	
}
