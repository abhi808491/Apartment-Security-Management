package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	@Disabled
	void addTest() 
	{
		DomesticHelpEntity domesticHelp=new DomesticHelpEntity();
		domesticHelp.setId(100);
		domesticHelp.setCreatedBy("rishitha");
		domesticHelp.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedBy("rishitha");
		domesticHelp.setOwnerName("Ramesh");
		domesticHelp.setArrivalTime("7:00 AM");
		domesticHelp.setDepartureTime("11:00 AM");
		domesticHelp.setFlatNo("300B");
		domesticHelp.setHelpType("cooking");
		long num=domesticHelpServ.add(domesticHelp);
		assertEquals(num,domesticHelp.getId());	
		
	}
	@Test
	void updateTest() 
	{
		DomesticHelpEntity domesticHelp=new DomesticHelpEntity();
		domesticHelp.setId(1);
		domesticHelp.setCreatedBy("rishitha");
		domesticHelp.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedBy("rishitha");
		domesticHelp.setOwnerName("Ramesh");
		domesticHelp.setArrivalTime("7:00 AM");
		domesticHelp.setDepartureTime("11:00 AM");
		domesticHelp.setFlatNo("300B");
		domesticHelp.setHelpType("cooking");
		domesticHelpServ.update(domesticHelp);
		DomesticHelpEntity newDomesticHelp=domesticHelpServ.findByPk(1);
		assertEquals(1,newDomesticHelp.getId());
		assertEquals("rishitha", newDomesticHelp.getCreatedBy());
		assertEquals("rishitha", newDomesticHelp.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"), newDomesticHelp.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"), newDomesticHelp.getModifiedDateTime());
		assertEquals("Ramesh", newDomesticHelp.getOwnerName());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"), newDomesticHelp.getDate());
		
		
	}
	
	@Test
	void findByPkTest() 
	{
		DomesticHelpEntity newDomesticHelp=domesticHelpServ.findByPk(1);
		assertEquals(1,newDomesticHelp.getId());
		assertEquals("rishitha", newDomesticHelp.getCreatedBy());
		assertEquals("rishitha", newDomesticHelp.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"), newDomesticHelp.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"), newDomesticHelp.getModifiedDateTime());
		assertEquals("Ramesh", newDomesticHelp.getOwnerName());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"), newDomesticHelp.getDate());
		
	}
	@Test
	void findByNameTest() 
	{
		DomesticHelpEntity newDomesticHelpEnt=domesticHelpServ.findByName("rani");
		System.out.println(newDomesticHelpEnt);
		assertEquals("rishitha",newDomesticHelpEnt.getCreatedBy());
		assertEquals(java.sql.Timestamp.valueOf(" 2022-03-25 14:04:33.228 "),newDomesticHelpEnt.getCreatedDateTime());
		assertEquals("rishitha",newDomesticHelpEnt.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-25 14:04:33.228"),newDomesticHelpEnt.getModifiedDateTime());
		assertEquals("rani",newDomesticHelpEnt.getOwnerName());
		assertEquals("7:00 AM",newDomesticHelpEnt.getArrivalTime());
		assertEquals("10:00 AM",newDomesticHelpEnt.getDepartureTime());
		assertEquals("104F",newDomesticHelpEnt.getFlatNo());
		assertEquals("cooking",newDomesticHelpEnt.getHelpType());
	}
	@Test
	public void DeleteTest() throws RecordNotFoundException{
		DomesticHelpEntity domesticHelp=new DomesticHelpEntity();
		domesticHelp.setId(10);
		domesticHelp.setCreatedBy("rishitha");
		domesticHelp.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedBy("rishitha");
		domesticHelp.setOwnerName("Ramesh");
		domesticHelp.setArrivalTime("7:00 AM");
		domesticHelp.setDepartureTime("11:00 AM");
		domesticHelp.setFlatNo("300B");
		domesticHelp.setHelpType("cooking");
		domesticHelpServ.add(domesticHelp);
		domesticHelpServ.delete(domesticHelp);
		assertThrows(RecordNotFoundException.class, ()->{
			domesticHelpServ.findByPk(domesticHelp.getId());
			});
	}
	

}
