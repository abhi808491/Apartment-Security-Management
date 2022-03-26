package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.aps.entity.GardShiftEntity;
import com.cg.aps.entity.GardsTranningEntity;
import com.cg.aps.service.GardsTranningServiceInt;

@SpringBootTest
public class GardsTranningTest {

	@Autowired
	GardsTranningServiceInt gardsTranningServ;

	@Test
	@Disabled
	void add() {
		GardsTranningEntity gard = new GardsTranningEntity();
		gard.setId(5);
		gard.setCreatedBy("Ranjan");
		gard.setModifiedBy("");
		gard.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setUserId(5);
		gard.setMobileNo("8051148432");
		gard.setStatus("under training");
		gard.setTimeing("9AM");
		gard.setDate(java.sql.Timestamp.valueOf("23-03-2022"));
		gardsTranningServ.add(gard);

		GardsTranningEntity newGard = new GardsTranningEntity();
		newGard.setId(gard.getId());
		newGard.setCreatedBy(gard.getCreatedBy());
		newGard.setCreatedDateTime(gard.getCreatedDateTime());
		newGard.setModifiedDateTime(gard.getModifiedDateTime());
		newGard.setUserId(gard.getUserId());
		newGard.setMobileNo(gard.getMobileNo());
		newGard.setStatus(gard.getStatus());
		newGard.setTimeing(gard.getTimeing());
		newGard.setDate(gard.getDate());
		assertEquals("Ranjan", newGard.getCreatedBy());
		assertEquals("9AM", newGard.getTimeing());
		assertEquals("5", newGard.getUserId());
		assertEquals("23-03-2022", newGard.getDate());
	}

	@Test
	void update() {
		GardsTranningEntity gard = gardsTranningServ.findByPk(5);
		gard.setName("Muskan");
		gard.setModifiedBy("Abhishek");
		gard.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gardsTranningServ.update(gard);

		GardsTranningEntity updatedGard = gardsTranningServ.findByPk(5);
		assertEquals("Muskan", updatedGard.getName());
		assertEquals("9AM", updatedGard.getTimeing());
	}

	@Test
	@Disabled
	void delete() {
		GardsTranningEntity gard = gardsTranningServ.findByPk(6);
		gardsTranningServ.delete(gard);
	}

	@Test
	void findByPk() {
		GardsTranningEntity gard = gardsTranningServ.findByPk(2);
		assertEquals("Sakshi Singh", gard.getName());
		assertEquals(2, gard.getUserId());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-24 00:00:00.0"), gard.getDate());
	}

}
