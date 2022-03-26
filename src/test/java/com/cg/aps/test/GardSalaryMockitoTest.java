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

import com.cg.aps.entity.GardSalaryEntity;
import com.cg.aps.repository.GardSalaryDAOInt;
import com.cg.aps.service.GardSalaryService;

@ExtendWith(SpringExtension.class)
class GardSalaryMockitoTest {

	@InjectMocks
	GardSalaryService gardSalaryServ;

	@MockBean
	GardSalaryDAOInt gardSalaryDAOInt;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void addTest() {
		GardSalaryEntity gard = new GardSalaryEntity();
		gard.setId(5);
		gard.setCreatedBy("Ranjan");
		gard.setModifiedBy("Ankit");
		gard.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setUserId("101");
		gard.setName("Arun");
		gard.setStatus("training");
		gard.setAmount(22000);
		gard.setDate(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		Mockito.when(gardSalaryDAOInt.save(gard)).thenReturn(gard);
		Long id=gardSalaryServ.add(gard);
		assertEquals("Ranjan", gard.getCreatedBy());
		assertEquals("Ankit", gard.getModifiedBy());
		assertEquals(id, gard.getId());
		assertEquals("101", gard.getUserId());
		assertEquals("Arun", gard.getName());

	}

	@Test
	void updateTest() {
		GardSalaryEntity gard = new GardSalaryEntity();
		gard.setId(5);
		gard.setCreatedBy("Ranjan");
		gard.setModifiedBy("Ankit");
		gard.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setUserId("101");
		gard.setName("Arun");
		gard.setStatus("training");
		gard.setAmount(22000);
		gard.setDate(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		Mockito.when(gardSalaryDAOInt.findById((long) 5)).thenReturn(Optional.of(gard));
		Mockito.when(gardSalaryDAOInt.save(gard)).thenReturn(gard);
		gardSalaryServ.update(gard);
		assertEquals("Ankit", gard.getModifiedBy());
		assertEquals("Arun", gard.getName());
		assertEquals("101", gard.getUserId());
		assertEquals(5, gard.getId());
	}

	@Test
	void deleteTest() {
		GardSalaryEntity gard = new GardSalaryEntity();
		gard.setId(5);
		gard.setCreatedBy("Ranjan");
		gard.setModifiedBy("Ankit");
		gard.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setUserId("101");
		gard.setName("Arun");
		gard.setStatus("training");
		gard.setAmount(22000);
		gard.setDate(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		Mockito.when(gardSalaryDAOInt.findById((long) 5)).thenReturn(Optional.of(gard));
		gardSalaryServ.delete(gard);
	}

	@Test
	void findByPk() {
		GardSalaryEntity gard = new GardSalaryEntity();
		gard.setId(5);
		gard.setCreatedBy("Ranjan");
		gard.setModifiedBy("Ankit");
		gard.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setUserId("101");
		gard.setName("Arun");
		gard.setStatus("training");
		gard.setAmount(22000);
		gard.setDate(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		Mockito.when(gardSalaryDAOInt.findById((long) 5)).thenReturn(Optional.of(gard));
		assertEquals("Ankit", gard.getModifiedBy());
		assertEquals("Arun", gard.getName());
		assertEquals("101", gard.getUserId());
		assertEquals(5, gard.getId());
	}
}