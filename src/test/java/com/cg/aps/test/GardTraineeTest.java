package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.aps.entity.GardTraineeEntity;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.GardTraineeServiceInt;

@SpringBootTest
public class GardTraineeTest {

	@Autowired
	GardTraineeServiceInt gardsTranningServ;

	@Test
	@Disabled
	void add() {
		GardTraineeEntity gard = new GardTraineeEntity();
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

		GardTraineeEntity newGard = new GardTraineeEntity();
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

	@Disabled
	@Test
	void update() {
		GardTraineeEntity gard = gardsTranningServ.findByPk(5);
		gard.setName("Muskan");
		gard.setModifiedBy("Abhishek");
		gard.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gardsTranningServ.update(gard);

		GardTraineeEntity updatedGard = gardsTranningServ.findByPk(5);
		assertEquals("Muskan", updatedGard.getName());
		assertEquals("9AM", updatedGard.getTimeing());
	}
	@Disabled
	@Test
	void delete()  throws RecordNotFoundException{
		GardTraineeEntity gard=gardsTranningServ.findByPk(4);
		gardsTranningServ.delete(gard);
		assertThrows(RecordNotFoundException.class, () -> {
			gardsTranningServ.findByPk(gard.getId());
		});
	}

	@Test
	void findByPk() {
		GardTraineeEntity gard = gardsTranningServ.findByPk(2);
		assertEquals("Rohith Sai", gard.getName());
		assertEquals(12, gard.getUserId());
		assertEquals(java.sql.Timestamp.valueOf(" 2022-03-28 11:04:39.092"), gard.getDate());
	}
	@Test
	void  getGardBySalaryId()
	{
		GardTraineeEntity gard = gardsTranningServ.getGardBySalaryId(53);
		assertEquals("Rohith Sai", gard.getName());
		assertEquals(12, gard.getUserId());
	}
	
	@Test
	void getAllGardTraineeByShiftId()
	{
		List<GardTraineeEntity> gardList=gardsTranningServ.getAllGardTraineeByShiftId(21);
		assertEquals("Rohith Sai",gardList.get(1).getName());
		assertEquals("Ankit kumar",gardList.get(0).getName());
	}

}
