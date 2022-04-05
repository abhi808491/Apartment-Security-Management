package com.cg.aps.test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.aps.entity.UserEntity;
import com.cg.aps.repository.UserDAOInt;
import com.cg.aps.service.UserService;

@ExtendWith(SpringExtension.class)
class UserMockitoTest {

	@InjectMocks
	UserService userServ;

	@MockBean
	UserDAOInt userDao;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void addTest() {
		Long adminPk=(long) 1;
		UserEntity user = new UserEntity();
		user.setId(5);
		user.setCreatedBy("Ram");
		user.setModifiedBy("");
		user.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		user.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		user.setLoginId("5");
		user.setMobileNo("8051148432");
		user.setEmailId("ram@gmail.com");
		user.setPassword("ram");
		user.setFirstName("Ram");
		user.setLastName("Kumar");
		user.setRoleId(0);
		if(adminPk==1) {	
		Mockito.when(userDao.save(user)).thenReturn(user);
		assertEquals(5,user.getId());
		assertEquals("Ram", user.getCreatedBy());
		assertEquals("8051148432", user.getMobileNo());
		
		}
	}

	@Test
	void updateTest() {
		UserEntity user = new UserEntity();
		user.setId(5);
		user.setCreatedBy("Ram");
		user.setModifiedBy("");
		user.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		user.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		user.setLoginId("5");
		user.setFirstName("Ram");
		user.setMobileNo("8051148432");
		user.setPassword("ram");
		user.setLastName("Kumar");
		Mockito.when(userDao.findById((long) 5)).thenReturn(Optional.of(user));
		Mockito.when(userDao.save(user)).thenReturn(user);
		userServ.update(user);
		assertEquals("Ram", user.getFirstName());

	}

	@Test
	void deleteTest() {
		UserEntity user = new UserEntity();
		
		user.setId(5);
		user.setCreatedBy("Ram");
		user.setModifiedBy("");
		user.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		user.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		user.setLoginId("5");
		user.setFirstName("Ram");
		user.setMobileNo("8051148432");
		user.setPassword("ram");
		user.setLastName("Kumar");
		Mockito.when(userDao.findById((long) 5)).thenReturn(Optional.of(user));
		
		UserEntity admin=new UserEntity();
		admin.setId(2);
		admin.setFirstName("Ram");
		admin.setRoleId(1);
		Mockito.when(userDao.findById((long) 2)).thenReturn(Optional.of(admin));
		if(admin.getRoleId()==1)
		userServ.delete(user,admin.getId());

	}

	@Test
	void findByPk() {
		UserEntity user = new UserEntity();
		user.setId(5);
		user.setCreatedBy("Ram");
		user.setModifiedBy("");
		user.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		user.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		user.setLoginId("5");
		user.setFirstName("Ram");
		user.setMobileNo("8051148432");
		user.setPassword("ram");
		user.setLastName("Kumar");
		Mockito.when(userDao.findById((long) 6)).thenReturn(Optional.of(user));

	}

}