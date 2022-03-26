package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.aps.entity.GardShiftEntity;
import com.cg.aps.service.GardShiftServiceInt;

@SpringBootTest
public class GardShiftTest {
	@Autowired
	GardShiftServiceInt gardShiftServ;

	public GardShiftEntity addGardShift() {
		GardShiftEntity gardShift = new GardShiftEntity();
		gardShift.setId(14);
		gardShift.setCreatedBy("Kailsah");
		gardShift.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gardShift.setUserId(23);
		gardShift.setName("Navin");
		gardShift.setTime("2PM");
		gardShift.setDate(java.sql.Timestamp.valueOf("23-03-2022"));
		Long id = gardShiftServ.add(gardShift);
		return gardShiftServ.findByPk(id);

	}

	@Test
	@Disabled
	void addTest() {
		GardShiftEntity newGard = addGardShift();
		assertEquals("Navin", newGard.getName());
		assertEquals(14, newGard.getId());
		assertNotEquals(24, newGard.getUserId());

	}

	@Test
	void updateTest() {
		GardShiftEntity gardShift = gardShiftServ.findByPk(13);
		gardShift.setModifiedBy("Ravan");
		gardShift.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gardShiftServ.update(gardShift);

		GardShiftEntity updatedGard = gardShiftServ.findByPk(13);
		assertEquals("Ravan", updatedGard.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"), updatedGard.getModifiedDateTime());
		assertEquals("Navin", updatedGard.getName());

	}

	@Test
	@Disabled
	void deleteTest() {
		GardShiftEntity gardShift = gardShiftServ.findByPk(14);
		gardShiftServ.delete(gardShift);
	}

	void findByPk() {
		GardShiftEntity gardShift = gardShiftServ.findByPk(11);
		assertEquals("Ankit", gardShift.getModifiedBy());
		assertEquals("9AM to 6PM", gardShift.getTime());
	}

}
