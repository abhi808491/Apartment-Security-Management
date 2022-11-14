package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.aps.entity.DomesticHelpEntity;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.DomesticHelpServiceInt;

@SpringBootTest
public class DomesticHelpTest {
	@Autowired
	DomesticHelpServiceInt domesticHelpServ;

	@Test
	void addTest() {
		DomesticHelpEntity domesticHelp = new DomesticHelpEntity();
		domesticHelp.setId(100);
		domesticHelp.setCreatedBy("rishitha");
		domesticHelp.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedBy("rishitha");
		domesticHelp.setName("raja");
		domesticHelp.setArrivalTime("7:00 AM");
		domesticHelp.setDepartureTime("11:00 AM");
		domesticHelp.setHelpType("electricity");
		long num = domesticHelpServ.add(domesticHelp);
		assertEquals(num, domesticHelp.getId());

	}

	@Test
	void updateTest() {
		DomesticHelpEntity domesticHelp = new DomesticHelpEntity();
		domesticHelp.setId(51);
		domesticHelp.setCreatedBy("rishitha");
		domesticHelp.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-30 09:14:58.932"));
		domesticHelp.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-30 09:14:58.932"));
		domesticHelp.setDate(java.sql.Timestamp.valueOf("2022-03-30 09:14:58.932"));
		domesticHelp.setModifiedBy("rishitha");
		domesticHelp.setName("Ray");
		domesticHelp.setArrivalTime("9:00 AM");
		domesticHelp.setDepartureTime("2:00 PM");
		domesticHelp.setHelpType("gardening");
		domesticHelpServ.update(domesticHelp);
		DomesticHelpEntity newDomesticHelp = domesticHelpServ.findByPk(51);
		assertEquals(51, newDomesticHelp.getId());
		assertEquals("rishitha", newDomesticHelp.getCreatedBy());
		assertEquals("rishitha", newDomesticHelp.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-30 09:14:58.932"), newDomesticHelp.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-30 09:14:58.932"), newDomesticHelp.getModifiedDateTime());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-30 09:14:58.932"), newDomesticHelp.getDate());

	}

	@Test
	void findByPkTest() {
		DomesticHelpEntity newDomesticHelp = domesticHelpServ.findByPk(51);
		assertEquals(51, newDomesticHelp.getId());
		assertEquals("rishitha", newDomesticHelp.getCreatedBy());
		assertEquals("rishitha", newDomesticHelp.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-30 09:14:58.932"), newDomesticHelp.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-30 09:14:58.932"), newDomesticHelp.getModifiedDateTime());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-30 09:14:58.932"), newDomesticHelp.getDate());

	}

	@Test
	void findByNameTest() {
		List<DomesticHelpEntity> newDomesticHelpEnt = domesticHelpServ.findByName("Rahul");

		assertEquals(1, newDomesticHelpEnt.size());
	}

	@Test
	public void DeleteTest() throws RecordNotFoundException {
		DomesticHelpEntity domesticHelp = domesticHelpServ.findByPk(100);
		domesticHelpServ.delete(domesticHelp);
		assertThrows(RecordNotFoundException.class, () -> {
			domesticHelpServ.findByPk(domesticHelp.getId());
		});
	}

	@Test
	public void searchTest() {
		DomesticHelpEntity domesticHelp = new DomesticHelpEntity();
		domesticHelp.setId(51);
		domesticHelp.setCreatedBy("rishitha");
		domesticHelp.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-30 09:14:58.932"));
		domesticHelp.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-30 09:14:58.932"));
		domesticHelp.setDate(java.sql.Timestamp.valueOf("2022-03-30 09:14:58.932"));
		domesticHelp.setModifiedBy("rishitha");
		domesticHelp.setName("Ray");
		domesticHelp.setArrivalTime("9:00 AM");
		domesticHelp.setDepartureTime("2:00 PM");
		domesticHelp.setHelpType("gardening");
		domesticHelpServ.update(domesticHelp);
		List<DomesticHelpEntity> newDomesticHelp = domesticHelpServ.search(domesticHelp);
		assertEquals(1, newDomesticHelp.size());
	}

}
