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

import com.cg.aps.entity.FlatRentEntity;
import com.cg.aps.repository.FlatRentDAOInt;
import com.cg.aps.service.FlatRentService;

@ExtendWith(SpringExtension.class)
class FlatRentMockitoTest {

	@InjectMocks
	FlatRentService flatRentServ;

	@MockBean
	FlatRentDAOInt flatRentDAOint;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void addTest() {
		FlatRentEntity flat = new FlatRentEntity();
		flat.setId(6);
		flat.setCreatedBy("Ranjan");
		flat.setModifiedBy("");
		flat.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setFlatNo("101");
		flat.setAmount("8000");
		flat.setType("3bhk");
		Mockito.when(flatRentDAOint.save(flat)).thenReturn(flat);
		long id = flatRentServ.add(flat);
		assertEquals(id,flat.getId());
		assertEquals("Ranjan", flat.getCreatedBy());
		assertEquals("101", flat.getFlatNo());
	}
	
	@Test
	void updateTest() {
		FlatRentEntity flat = new FlatRentEntity();
		flat.setId(6);
		flat.setCreatedBy("RanjanT");
		flat.setModifiedBy("");
		flat.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setOwnerName("RahulT");
		flat.setFlatNo("103");
		flat.setAmount("8000");
		flat.setType("3bhk");
		Mockito.when(flatRentDAOint.findById((long) 6)).thenReturn(Optional.of(flat));
		Mockito.when(flatRentDAOint.save(flat)).thenReturn(flat);
		flatRentServ.update(flat);
		assertEquals("103",flat.getFlatNo());
		assertEquals("RahulT", flat.getOwnerName());
	}
	
	@Test
	void deleteTest() {
		FlatRentEntity flat = new FlatRentEntity();
		flat.setId(6);
		flat.setCreatedBy("Ranjan");
		flat.setModifiedBy("");
		flat.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setOwnerName("Rahul");
		flat.setFlatNo("101");
		flat.setAmount("8000");
		flat.setType("3bhk");
		Mockito.when(flatRentDAOint.findById((long) 6)).thenReturn(Optional.of(flat));
		flatRentServ.delete(flat);

	}
	
	@Test
	void findByPk() {
		FlatRentEntity flat = new FlatRentEntity();
		flat.setId(6);
		flat.setCreatedBy("Ranjan");
		flat.setModifiedBy("");
		flat.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setOwnerName("Rahul");
		flat.setFlatNo("101");
		flat.setAmount("8000");
		flat.setType("3bhk");
		Mockito.when(flatRentDAOint.findById((long) 6)).thenReturn(Optional.of(flat));

	}
}
