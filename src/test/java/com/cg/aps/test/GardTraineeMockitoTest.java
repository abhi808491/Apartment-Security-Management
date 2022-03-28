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

import com.cg.aps.entity.GardTraineeEntity;
import com.cg.aps.repository.GardTraineeDAOInt;
import com.cg.aps.service.GardTraineeService;

@ExtendWith(SpringExtension.class)
class GardTraineeMockitoTest {

	@InjectMocks
	GardTraineeService gardsTranningServ;

	@MockBean
	GardTraineeDAOInt gardsTraineeDAOInt;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void addTest() {
		GardTraineeEntity gard = new GardTraineeEntity();
		gard.setId(5);
		gard.setCreatedBy("Ranjan");
		gard.setModifiedBy("");
		gard.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setUserId(6);
		gard.setMobileNo("8051148432");
		gard.setStatus("under training");
		gard.setTimeing("9AM");
		gard.setDate(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		Mockito.when(gardsTraineeDAOInt.save(gard)).thenReturn(gard);
		long id = gardsTranningServ.add(gard);
		assertEquals(id,gard.getId());
		assertEquals("Ranjan", gard.getCreatedBy());
		assertEquals("8051148432", gard.getMobileNo());

	}

	@Test
	void updateTest() {
		GardTraineeEntity gard = new GardTraineeEntity();
		gard.setId(6);
		gard.setCreatedBy("Ranjan");
		gard.setModifiedBy("");
		gard.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setDate(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setUserId(6);
		gard.setName("Rahul");
		gard.setMobileNo("8051148432");
		gard.setStatus("under training");
		gard.setTimeing("9AM");
		Mockito.when(gardsTraineeDAOInt.findById((long) 6)).thenReturn(Optional.of(gard));
		Mockito.when(gardsTraineeDAOInt.save(gard)).thenReturn(gard);
		gardsTranningServ.update(gard);
		assertEquals("Rahul", gard.getName());

	}

	@Test
	void deleteTest() {
		GardTraineeEntity gard = new GardTraineeEntity();
		
		// adding trainee
		gard.setId(6);
		gard.setCreatedBy("Ranjan");
		gard.setModifiedBy("");
		gard.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setDate(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setUserId(6);
		gard.setName("Rahul");
		gard.setMobileNo("8051148432");
		gard.setStatus("under training");
		gard.setTimeing("9AM");
		
		//handeling void
		
		Mockito.when(gardsTraineeDAOInt.findById((long) 6)).thenReturn(Optional.of(gard));
		Mockito.doNothing().when(gardsTraineeDAOInt).delete(gard);
		
		//deleteing
		gardsTranningServ.delete(gard);
		

	}

	@Test
	void findByPk() {
		GardTraineeEntity gard = new GardTraineeEntity();
		gard.setId(6);
		gard.setCreatedBy("Ranjan");
		gard.setModifiedBy("");
		gard.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setDate(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setUserId(6);
		gard.setName("Rahul");
		gard.setMobileNo("8051148432");
		gard.setStatus("under training");
		gard.setTimeing("9AM");
		Mockito.when(gardsTraineeDAOInt.findById((long) 6)).thenReturn(Optional.of(gard));

	}

}
