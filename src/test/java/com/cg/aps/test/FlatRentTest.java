package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.aps.entity.FlatRentEntity;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.FlatRentServiceInt;

@SpringBootTest
public class FlatRentTest {
	@Autowired
	FlatRentServiceInt flatRentServ;

	@Test
	void add() {
		FlatRentEntity flat = new FlatRentEntity();
		flat.setId(6);
		flat.setCreatedBy("Ranjan");
		flat.setModifiedBy("");
		flat.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setOwnerName("Sunil");
		flat.setFlatNo("101");
		flat.setAmount("8000");
		flat.setType("3bhk");
		long num=flatRentServ.add(flat);
		assertEquals(num,flat.getId());	
	}

	@Test
	void update() {
		FlatRentEntity flat = new FlatRentEntity();
		flat.setId(6);
		flat.setCreatedBy("Ranjan");
		flat.setModifiedBy("");
		flat.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setOwnerName("Mahesh");
		flat.setFlatNo("202");
		flat.setType("3bhk");
		flatRentServ.update(flat);
		
		FlatRentEntity newFlat = new FlatRentEntity();
		assertEquals(6,newFlat.getId());
		assertEquals("Ranjan",newFlat.getCreatedBy());
		assertEquals("",newFlat.getModifiedBy());
		assertEquals("Mahesh",newFlat.getOwnerName());
		assertEquals("202",newFlat.getFlatNo());
		assertEquals("3bhk",newFlat.getType());
	}

	@Test
	void findByPk() {
		FlatRentEntity flat = flatRentServ.findByPk(6);
		assertEquals(6,flat.getId());
		assertEquals("Ranjan",flat.getCreatedBy());
		assertEquals("",flat.getModifiedBy());
		assertEquals("Mahesh",flat.getOwnerName());
		assertEquals("202",flat.getFlatNo());
		assertEquals("3bhk",flat.getType());
	}
	
	@Test
	void findByNameTest() 
	{
		FlatRentEntity flat=flatRentServ.findByName("Mahesh");
		assertEquals(6,flat.getId());
		assertEquals("Ranjan",flat.getCreatedBy());
		assertEquals("",flat.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-25 13:44:47.14"),flat.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf(" 2022-03-25 13:44:47.14"),flat.getModifiedDateTime());
		assertEquals("Mahesh",flat.getOwnerName());
		assertEquals("202",flat.getFlatNo());
		assertEquals("3bhk",flat.getType());
	}
	
	@Test
	void delete() {
		FlatRentEntity flat = new FlatRentEntity();
		flat.setId(6);
		flat.setCreatedBy("Ranjan");
		flat.setModifiedBy("");
		flat.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setOwnerName("Sunil");
		flat.setFlatNo("101");
		flat.setType("3bhk");
		flatRentServ.add(flat);
		flatRentServ.delete(flat);
		assertThrows(RecordNotFoundException.class, ()->{
			flatRentServ.findByPk(flat.getId());
			});
	}

}
