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

import com.cg.aps.dto.GardTraineeDto;
import com.cg.aps.entity.DeliveryEntity;
import com.cg.aps.entity.DomesticHelpEntity;
import com.cg.aps.entity.GardShiftEntity;
import com.cg.aps.entity.GardTraineeEntity;
import com.cg.aps.entity.SecurityEntity;
import com.cg.aps.entity.VisitorEntity;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.GardTraineeServiceInt;

@SpringBootTest
public class GardTraineeTest {

	@Autowired
	GardTraineeServiceInt gardsTranningServ;

	public GardTraineeEntity addGardShift() {
		GardTraineeEntity gard = new GardTraineeEntity();
		gard.setId(79);
		gard.setCreatedBy("Ranjan");
		gard.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		gard.setUserId(18);
		gard.setName("Navin");
		gard.setMobileNo("7004657498");
		gard.setStatus("underTraining");

		gard.setDate(java.sql.Timestamp.valueOf("2022-03-24 10:10:10.0"));
		Long id = gardsTranningServ.addGard(gard);
		return gardsTranningServ.findByPk(id);
	}

	@Disabled
	@Test
	void add() {
		GardTraineeEntity gard = addGardShift();
		assertEquals("Ranjan", gard.getCreatedBy());
		// assertEquals("9AM", gard.getTimeing());
		assertEquals(79, gard.getId());

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
	void delete() throws RecordNotFoundException {
		GardTraineeEntity gard = gardsTranningServ.findByPk(79);
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
	void findByname() {
		GardTraineeEntity gard = gardsTranningServ.getByName("Rohith Sai");
		assertEquals("Rohith Sai", gard.getName());
		assertEquals(12, gard.getUserId());
		assertEquals(java.sql.Timestamp.valueOf(" 2022-03-28 11:04:39.092"), gard.getDate());
	}

	@Test
	void search() {
		GardTraineeEntity serachGard = gardsTranningServ.findByPk(2);
		List<GardTraineeEntity> gard = gardsTranningServ.search(serachGard);
		for (GardTraineeEntity gards : gard) {
			assertEquals("Rohith Sai", gards.getName());
			assertEquals(12, gards.getUserId());
			assertEquals(java.sql.Timestamp.valueOf(" 2022-03-28 11:04:39.092"), gards.getDate());
		}

	}

	@Test
	void getGardBySalaryId() {
		GardTraineeEntity gard = gardsTranningServ.getGardBySalaryId(53);
		assertEquals("Rohith Sai", gard.getName());
		assertEquals(12, gard.getUserId());
	}

	@Test
	void getAllGardTraineeByShiftId() {
		List<GardTraineeEntity> gardList = gardsTranningServ.getAllGardTraineeByShiftId(21);
		assertEquals("Rohith Sai", gardList.get(1).getName());
		assertEquals("Ankit kumar", gardList.get(0).getName());
	}
	@Test
	void getDomesticHelpByGardId()
	{
		List<DomesticHelpEntity> list = gardsTranningServ.getDomesticHelpByGardId(1);
		assertEquals("Vinod", list.get(0).getName());
		assertEquals("Ronit", list.get(1).getName());
	}
	
	@Test
	void getDeliveryListByGardId()
	{
		List<DeliveryEntity> list = gardsTranningServ.getDeliveryListByGardId(2);
		assertEquals("Ram Krishina", list.get(0).getOwnerName());
		assertEquals("Delivered", list.get(0).getStatus());
	}
	
	@Test
	void getVisitorByGardId()
	{
		List<VisitorEntity> list = gardsTranningServ.getVisitorByGardId(9);
		assertEquals("Eahul", list.get(0).getVisitorName());
		assertEquals("Sabnam", list.get(1).getVisitorName());
	}
	
	@Test
	void getSecurityByGard()
	{
		List<SecurityEntity> list = gardsTranningServ.getSecurityByGard(2);
		assertEquals("Abhishek Kumar", list.get(0).getCreatedBy());
		assertEquals("Fire alert", list.get(0).getAlert());
	}

}
