package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.aps.entity.VisitorEntity;
import com.cg.aps.exception.RecordNotFoundException;

import com.cg.aps.service.VisitorServiceInt;

@SpringBootTest
public class VisitorTest {
	
	@Autowired
	VisitorServiceInt visServ;
	
	@Test
	@Disabled
	void addTest() 
	{
		VisitorEntity visitor = new VisitorEntity();
		visitor.setId(1);
		visitor.setCreatedBy("Ateeq");
		visitor.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		visitor.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		visitor.setModifiedBy("Ateeq");
		visitor.setArrivalDate(LocalDate.of(2022,03,26));
		visitor.setDepartureDate(LocalDate.of(20220,03,27));
		visitor.setFlatNo(401);
		visitor.setVisitorId(11);
		visitor.setOwnerName("Ateeq");
		visitor.setVisitorName("Rahul");
		long n = visServ.addVisitor(visitor);
		assertEquals(n,visitor.getId());
	}
	@Test
	void updateTest() 
	{
		VisitorEntity visitor = new VisitorEntity();
		visitor.setId(1);
		visitor.setCreatedBy("Ateeq");
		visitor.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		visitor.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		visitor.setModifiedBy("Ateeq");
		visitor.setArrivalDate(LocalDate.of(2022,03,26));
		visitor.setDepartureDate(LocalDate.of(2022,03,27));
		visitor.setFlatNo(401);
		visitor.setVisitorId(11);
		visitor.setVisitorName("Rahul");
		visitor.setOwnerName("Ateeq");
		visServ.updateVisitor(visitor);
		VisitorEntity newVisitor = visServ.findByPk(1);
		assertEquals(1,newVisitor.getId());
		assertEquals("Ateeq", newVisitor.getOwnerName());
		assertEquals("Ateeq", newVisitor.getCreatedBy());
		assertEquals("Ateeq", newVisitor.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"), newVisitor.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"), newVisitor.getModifiedDateTime());
		assertEquals(LocalDate.of(2022,03,26), newVisitor.getArrivalDate());
		assertEquals(LocalDate.of(2022,03,27), newVisitor.getDepartureDate());
		assertEquals(401,newVisitor.getFlatNo());
		assertEquals(11,newVisitor.getVisitorId());
		assertEquals("Rahul",newVisitor.getVisitorName());
		
	}
	@Test
	void findByPkTest() 
	{
		VisitorEntity newVisitor = visServ.findByPk(1);
		assertEquals(1,newVisitor.getId());
		assertEquals("Ateeq", newVisitor.getOwnerName());
		assertEquals("Ateeq", newVisitor.getCreatedBy());
		assertEquals("Ateeq", newVisitor.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"), newVisitor.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"), newVisitor.getModifiedDateTime());
		assertEquals(LocalDate.of(2022,03,26), newVisitor.getArrivalDate());
		assertEquals(LocalDate.of(2022,03,27), newVisitor.getDepartureDate());
		assertEquals(401,newVisitor.getFlatNo());
		assertEquals(11,newVisitor.getVisitorId());
		assertEquals("Rahul",newVisitor.getVisitorName());
	}
	
	@Test
	public void DeleteTest() throws RecordNotFoundException{
		VisitorEntity visitor = new VisitorEntity();
		visitor.setId(100);
		visitor.setCreatedBy("Ateeq");
		visitor.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		visitor.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		visitor.setModifiedBy("Ateeq");
		visitor.setOwnerName("Ateeq");
		visitor.setArrivalDate(LocalDate.of(2022,03,26));
		visitor.setDepartureDate(LocalDate.of(20220,03,27));
		visitor.setFlatNo(402);
		visitor.setVisitorId(112);
		visitor.setVisitorName("Ram");
		visServ.addVisitor(visitor);
		visServ.deleteVisitor(visitor);
		assertThrows(RecordNotFoundException.class, ()->{
			visServ.findByPk(visitor.getId());
			});
	}
}
	