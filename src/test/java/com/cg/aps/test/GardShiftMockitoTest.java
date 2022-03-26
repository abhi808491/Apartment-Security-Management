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

import com.cg.aps.entity.GardShiftEntity;
import com.cg.aps.repository.GardShiftDAOInt;
import com.cg.aps.service.GardShiftService;

@ExtendWith(SpringExtension.class)
class GardShiftMockitoTest {

	@InjectMocks
	GardShiftService gardShiftServ;

	@MockBean
	GardShiftDAOInt gardShiftDAOInt;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void addTest() {
		GardShiftEntity gard = new GardShiftEntity();
		gard.setId(5);
		gard.setCreatedBy("Ranjan");
		gard.setModifiedBy("Ankit");
		gard.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setUserId(6);
		gard.setName("Radha");
		gard.setTime("7AM");
		gard.setDate(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		Mockito.when(gardShiftDAOInt.save(gard)).thenReturn(gard);
		assertEquals("Ranjan", gard.getCreatedBy());
		assertEquals("Ankit", gard.getModifiedBy());
		assertEquals(5, gard.getId());
	}

	@Test
	void updateTest() {
		GardShiftEntity gard = new GardShiftEntity();
		gard.setId(5);
		gard.setCreatedBy("Ranjan");
		gard.setModifiedBy("Ankit");
		gard.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setUserId(6);
		gard.setName("Radha");
		gard.setTime("7AM");
		gard.setDate(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		Mockito.when(gardShiftDAOInt.findById((long) 5)).thenReturn(Optional.of(gard));
		Mockito.when(gardShiftDAOInt.save(gard)).thenReturn(gard);
		gardShiftServ.update(gard);
		assertEquals("Radha", gard.getName());
		assertEquals("Ankit", gard.getModifiedBy());

	}

	@Test
	void deleteTest() {
		GardShiftEntity gard = new GardShiftEntity();
		gard.setId(5);
		gard.setCreatedBy("Ranjan");
		gard.setModifiedBy("Ankit");
		gard.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setUserId(6);
		gard.setName("Radha");
		gard.setTime("7AM");
		gard.setDate(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		Mockito.when(gardShiftDAOInt.findById((long) 5)).thenReturn(Optional.of(gard));
		gardShiftServ.delete(gard);
	}

	@Test
	void findByPk() {
		GardShiftEntity gard = new GardShiftEntity();
		gard.setId(5);
		gard.setCreatedBy("Ranjan");
		gard.setModifiedBy("Ankit");
		gard.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setUserId(6);
		gard.setName("Radha");
		gard.setTime("7AM");
		gard.setDate(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		Mockito.when(gardShiftDAOInt.findById((long) 5)).thenReturn(Optional.of(gard));
		assertEquals("Ranjan", gard.getCreatedBy());
		assertEquals("Ankit", gard.getModifiedBy());
		assertEquals(5, gard.getId());

	}

}
