package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.aps.entity.SecurityEntity;

import com.cg.aps.repository.SecurityDAOInt;
import com.cg.aps.service.SecurityService;


@ExtendWith(SpringExtension.class)
public class SecurityMockitoTest {
	@InjectMocks
	SecurityService securityService;
	@MockBean
	SecurityDAOInt secRepo;
	@BeforeEach
	void init()
	{
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void addSecurityTest() 
	{
		SecurityEntity security= new SecurityEntity();
		security.setId(12);
		security.setCreatedBy("Ateeq");
		security.setModifiedBy("Ateeq");
		security.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		security.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		security.setAlert("Car outside");
		security.setMessage("Open Gate");
		Mockito.when(secRepo.save(security)).thenReturn(security);
		long n= securityService.add(security);
		assertEquals(12,n);
}

	@Test
	void updateTest() 
	{
		SecurityEntity security= new SecurityEntity();
		security.setId(12);
		security.setCreatedBy("Ateeq");
		security.setModifiedBy("Ateeq");
		security.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		security.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		security.setAlert("no car outside");
		security.setMessage("close Gate");
		Mockito.when(secRepo.findById((long) 12)).thenReturn(Optional.of(security));
		Mockito.when(secRepo.save(security)).thenReturn(security);
		securityService.update(security);
		assertEquals("no car outside",security.getAlert());
		
	}
	@Test
	void findByPkTest() 
	{
		SecurityEntity security= new SecurityEntity();
		security.setId(20);
		security.setCreatedBy("Ateeq");
		security.setModifiedBy("Ateeq");
		security.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		security.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		security.setAlert("Car outside");
		security.setMessage("Open Gate");
		Mockito.when(secRepo.findById((long) 20)).thenReturn(Optional.of(security));
	    SecurityEntity secEnt = securityService.findByPk(20);
		assertEquals(20,secEnt.getId());
		assertEquals("Ateeq",secEnt.getCreatedBy());
		assertEquals("Ateeq",secEnt.getModifiedBy());
		assertEquals("Car outside",secEnt.getAlert());
		assertEquals("Open Gate",secEnt.getMessage());
	}	
}
