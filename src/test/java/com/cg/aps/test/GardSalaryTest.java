package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.aps.entity.GardSalaryEntity;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.GardSalaryServiceInt;

@SpringBootTest
public class GardSalaryTest {
	@Autowired
	GardSalaryServiceInt gardSalaryServ;

	public GardSalaryEntity addSalary() {
		GardSalaryEntity gard = new GardSalaryEntity();
		gard.setId(54);
		gard.setCreatedBy("Ranbir");
		gard.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-04-24 20:10:10.0"));
		gard.setUserId("104");
		gard.setAmount(36000);
		gard.setDate(java.sql.Timestamp.valueOf("24-03-2022"));
		gard.setName("Ritik");
		gard.setStatus("salary credited");
		Long id = gardSalaryServ.add(gard);
		return gardSalaryServ.findByPk(id);
	}

	@Test
	@Disabled
	void addTest() {
		GardSalaryEntity gard = addSalary();
		assertEquals("Ritik", gard.getName());
		assertEquals(36000, gard.getAmount());
		assertEquals(java.sql.Timestamp.valueOf("2022-04-24 20:10:10.0"), gard.getCreatedDateTime());

	}

	@Test
	void updateTest() {
		GardSalaryEntity gard = gardSalaryServ.findByPk(53);
		gard.setModifiedBy("Abhishek");
		gard.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-04-24 20:10:10.0"));
		gardSalaryServ.update(gard);

		GardSalaryEntity updatedGard = gardSalaryServ.findByPk(53);
		assertEquals("Abhishek", updatedGard.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-04-24 20:10:10.0"), updatedGard.getModifiedDateTime());
	}

	@Test
	@Disabled
	void deleteTest() {
		GardSalaryEntity gard = gardSalaryServ.findByPk(54);
		gardSalaryServ.delete(gard);
		
		assertThrows(RecordNotFoundException.class, () -> {
			gardSalaryServ.findByPk(gard.getId());
		});
	}

	@Test
	void findByPk() {
		GardSalaryEntity gard = gardSalaryServ.findByPk(52);
		assertEquals("Arun", gard.getCreatedBy());
		assertEquals(22500, gard.getAmount());
	}

}
