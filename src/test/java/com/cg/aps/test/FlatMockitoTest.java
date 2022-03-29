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

import com.cg.aps.entity.FlatEntity;
import com.cg.aps.repository.FlatDAOInt;
import com.cg.aps.service.FlatService;

@ExtendWith(SpringExtension.class)
class FlatMockitoTest {

	@InjectMocks
	FlatService flatServ;

	@MockBean
	FlatDAOInt flatDAOint;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void addTest() {
		FlatEntity flat = new FlatEntity();
		flat.setId(6);
		flat.setCreatedBy("Ranjan");
		flat.setModifiedBy("");
		flat.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setFlatNo("101");
		flat.setFloorNo("1");
		flat.setFlatType("3bhk");
		Mockito.when(flatDAOint.save(flat)).thenReturn(flat);
		long id = flatServ.add(flat);
		assertEquals(id,flat.getId());
		assertEquals("Ranjan", flat.getCreatedBy());
		assertEquals("101", flat.getFlatNo());
	}
	
	@Test
	void updateTest() {
		FlatEntity flat = new FlatEntity();
		flat.setId(6);
		flat.setCreatedBy("Ranjan");
		flat.setModifiedBy("");
		flat.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setOwnerName("RahulT");
		flat.setFlatNo("103");
		flat.setFloorNo("1");
		flat.setFlatType("3bhk");
		Mockito.when(flatDAOint.findById((long) 6)).thenReturn(Optional.of(flat));
		Mockito.when(flatDAOint.save(flat)).thenReturn(flat);
		flatServ.update(flat);
		assertEquals("RahulT", flat.getOwnerName());
		assertEquals("103", flat.getFlatNo());
	}
	
	@Test
	void deleteTest() {
		FlatEntity flat = new FlatEntity();
		flat.setId(6);
		flat.setCreatedBy("Ranjan");
		flat.setModifiedBy("");
		flat.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setOwnerName("Rahul");
		flat.setFlatNo("101");
		flat.setFloorNo("1");
		flat.setFlatType("3bhk");
		Mockito.when(flatDAOint.findById((long) 6)).thenReturn(Optional.of(flat));
		flatServ.delete(flat);

	}
	
	@Test
	void findByPk() {
		FlatEntity flat = new FlatEntity();
		flat.setId(6);
		flat.setCreatedBy("Ranjan");
		flat.setModifiedBy("");
		flat.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setOwnerName("Rahul");
		flat.setFlatNo("101");
		flat.setFloorNo("1");
		flat.setFlatType("3bhk");
		Mockito.when(flatDAOint.findById((long) 6)).thenReturn(Optional.of(flat));

	}
}
