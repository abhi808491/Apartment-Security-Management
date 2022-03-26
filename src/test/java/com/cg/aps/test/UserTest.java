package com.cg.aps.test;



	import static org.junit.jupiter.api.Assertions.assertEquals;

	import java.text.ParseException;

	import org.junit.jupiter.api.Disabled;
	import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;

	import com.cg.aps.entity.UserEntity;
	import com.cg.aps.service.UserServiceInt;

	@SpringBootTest
	public class UserTest {

		@Autowired
		UserServiceInt userServ;
		
		
		@Test
		
		void addTest(){ 
		
			UserEntity user=new UserEntity();
			user.setId(5);
			user.setCreatedBy("Shyam");
			user.setModifiedBy("");
			user.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
			user.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
			user.setLoginId("5");
			user.setMobileNo("9234899986");
			user.setEmailId("ram@gmail.com");
			user.setPassword("ram");
			user.setFirstName("Ram");
			user.setLastName("Kumar");
			user.setRoleId(25);
			
			
		Long userId= userServ.add(user);
		
			assertEquals(5,userId);
		}
		@Test
		void update()
		{
			UserEntity user=new UserEntity();
			user.setId(5);
			user.setCreatedBy("Manish");
			user.setModifiedBy("Shyam");
			user.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
			user.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
			user.setLoginId("5");
			user.setMobileNo("9234899986");
			user.setEmailId("manish@gmail.com");
			user.setPassword("ram");
			user.setFirstName("Ram");
			user.setLastName("Kumar");
			user.setRoleId(5);
			userServ.update(user);
			
			UserEntity updatedUser=userServ.findByPk(5);
			assertEquals("Ram",updatedUser.getFirstName());
			assertEquals("Kumar",updatedUser.getLastName());
			assertEquals("Shyam",updatedUser.getModifiedBy());
		}
		@Test
		
		void delete()
		{
			UserEntity user=userServ.findByPk(5);
			userServ.delete(user);
			
			
		}
		@Test
		void findByPk()
		{
			UserEntity user=userServ.findByPk(5);
		}
			
			
			
			
			
		}


