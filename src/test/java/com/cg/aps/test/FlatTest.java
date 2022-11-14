package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.aps.entity.FlatEntity;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.FlatServiceInt;

@SpringBootTest
public class FlatTest {
	@Autowired
	FlatServiceInt flatServ;

	@Test
	void add() {
		FlatEntity flat = new FlatEntity();
		flat.setId(5);
		flat.setCreatedBy("Ranjan");
		flat.setModifiedBy("");
		flat.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setOwnerName("Sunil");
		flat.setFlatNo("101");
		flat.setFloorNo("1");
		flat.setFlatType("3bhk");
		long num=flatServ.add(flat);
		assertEquals(num,flat.getId());	
	}

	@Test
	void update() {
		FlatEntity flat = new FlatEntity();
		flat.setId(5);
		flat.setCreatedBy("Ranjan");
		flat.setModifiedBy("");
		flat.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setOwnerName("Mahesh");
		flat.setFlatNo("202");
		flat.setFloorNo("2");
		flat.setFlatType("3bhk");
		flatServ.update(flat);
		
		FlatEntity newFlat = new FlatEntity();
		assertEquals(5,newFlat.getId());
		assertEquals("Ranjan",newFlat.getCreatedBy());
		assertEquals("",newFlat.getModifiedBy());
		assertEquals("Mahesh",newFlat.getOwnerName());
		assertEquals("202",newFlat.getFlatNo());
		assertEquals("2",newFlat.getFloorNo());
		assertEquals("3bhk",newFlat.getFlatType());
	}

	@Test
	void findByPk() {
		FlatEntity flat = flatServ.findByPk(5);
		assertEquals(5,flat.getId());
		assertEquals("Ranjan",flat.getCreatedBy());
		assertEquals("",flat.getModifiedBy());
		assertEquals("Mahesh",flat.getOwnerName());
		assertEquals("202",flat.getFlatNo());
		assertEquals("2",flat.getFloorNo());
		assertEquals("3bhk",flat.getFlatType());
	}
	
	@Test
	void findByNameTest() 
	{
		FlatEntity flat=flatServ.findByOwnerName("mahesh");
		assertEquals(1,flat.getId());
		assertEquals("Ranjan",flat.getCreatedBy());
		assertEquals("",flat.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-25 13:44:47.14"),flat.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf(" 2022-03-25 13:44:47.14"),flat.getModifiedDateTime());
		assertEquals("Mahesh",flat.getOwnerName());
		assertEquals("202",flat.getFlatNo());
		assertEquals("2",flat.getFloorNo());
		assertEquals("3bhk",flat.getFlatType());
	}
	
	@Test
	void delete() {
		FlatEntity flat = new FlatEntity();
		flat.setId(5);
		flat.setCreatedBy("Ranjan");
		flat.setModifiedBy("");
		flat.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		flat.setOwnerName("Sunil");
		flat.setFlatNo("101");
		flat.setFloorNo("1");
		flat.setFlatType("3bhk");
		flatServ.add(flat);
		flatServ.delete(flat);
		assertThrows(RecordNotFoundException.class, ()->{
			flatServ.findByPk(flat.getId());
			});
	}

}
