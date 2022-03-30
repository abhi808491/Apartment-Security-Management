package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.aps.entity.GardShiftEntity;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.GardShiftServiceInt;

@SpringBootTest
public class GardShiftTest {
	@Autowired
	GardShiftServiceInt gardShiftServ;

	public GardShiftEntity addGardShift() {
		GardShiftEntity gardShift = new GardShiftEntity();
		gardShift.setId(25);
		gardShift.setCreatedBy("Abhishek Kumar");
		gardShift.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gardShift.setUserId(35);
		gardShift.setName("Navin");
		gardShift.setTime("2PM");
		gardShift.setDate(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		Long id = gardShiftServ.add(gardShift);
		return gardShiftServ.findByPk(id);

	}

	@Disabled
	@Test
	void addTest() {
		GardShiftEntity newGard = addGardShift();
		assertEquals("Navin", newGard.getName());
		assertEquals(25, newGard.getId());
		assertNotEquals(35, newGard.getUserId());

	}

	@Disabled
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
	void deleteTest() {
		GardShiftEntity gardShift = gardShiftServ.findByPk(25);
		gardShiftServ.delete(gardShift);
		assertThrows(RecordNotFoundException.class, () -> {
			gardShiftServ.findByPk(gardShift.getId());
		});
	}

	@Test
	void findByPk() {
		GardShiftEntity gardShift = gardShiftServ.findByPk(21);
		assertEquals("Morning Shift", gardShift.getName());
		assertEquals("6AM to 4PM", gardShift.getTime());
	}

	@Test
	void getByName() {
		GardShiftEntity gardShift = gardShiftServ.getByName("Morning Shift");
		assertEquals("Morning Shift", gardShift.getName());
		assertEquals("6AM to 4PM", gardShift.getTime());
	}

	@Test
	void serach() {
		GardShiftEntity gardShift = gardShiftServ.findByPk(21);
		List<GardShiftEntity> searchShift = gardShiftServ.search(gardShift);
		for (GardShiftEntity shift : searchShift) {
			assertEquals("Morning Shift", shift.getName());
			assertEquals("6AM to 4PM", shift.getTime());
		}
	}

}
