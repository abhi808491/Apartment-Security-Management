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

import com.cg.aps.entity.GardsTranningEntity;
import com.cg.aps.repository.GardsTranningDAOInt;
import com.cg.aps.service.GardsTranningService;

@ExtendWith(SpringExtension.class)
class GardTranningMockitoTest {

	@InjectMocks
	GardsTranningService gardsTranningServ;

	@MockBean
	GardsTranningDAOInt gardsTranningDAOInt;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void addTest() {
		GardsTranningEntity gard = new GardsTranningEntity();
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
		Mockito.when(gardsTranningDAOInt.save(gard)).thenReturn(gard);
		long id = gardsTranningServ.add(gard);
		assertEquals("Ranjan", gard.getCreatedBy());
		assertEquals("8051148432", gard.getMobileNo());

	}

	@Test
	void updateTest() {
		GardsTranningEntity gard = new GardsTranningEntity();
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
		Mockito.when(gardsTranningDAOInt.findById((long) 6)).thenReturn(Optional.of(gard));
		Mockito.when(gardsTranningDAOInt.save(gard)).thenReturn(gard);
		gardsTranningServ.update(gard);
		assertEquals("Rahul", gard.getName());

	}

	@Test
	void deleteTest() {
		GardsTranningEntity gard = new GardsTranningEntity();
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
		Mockito.when(gardsTranningDAOInt.findById((long) 6)).thenReturn(Optional.of(gard));
		gardsTranningServ.delete(gard);

	}

	@Test
	void findByPk() {
		GardsTranningEntity gard = new GardsTranningEntity();
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
		Mockito.when(gardsTranningDAOInt.findById((long) 6)).thenReturn(Optional.of(gard));

	}

}
