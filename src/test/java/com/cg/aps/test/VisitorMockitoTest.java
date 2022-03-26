package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.aps.entity.VisitorEntity;

import com.cg.aps.repository.VisitorDAOInt;
import com.cg.aps.service.VisitorService;

@ExtendWith(SpringExtension.class)
public class VisitorMockitoTest {
	@InjectMocks
	VisitorService visitorService;
	@MockBean
	VisitorDAOInt visRepo;
	@BeforeEach
	void init()
	{
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void addVisitorTest()
	{
		
		VisitorEntity visitor = new VisitorEntity();
		visitor.setId(101);
		visitor.setCreatedBy("Ateeq");
		visitor.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		visitor.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		visitor.setModifiedBy("Ateeq");
		visitor.setOwnerName("Ateeq");
		visitor.setArrivalDate(LocalDate.of(2022,03,26));
		visitor.setDepartureDate(LocalDate.of(20220,03,27));
		visitor.setFlatNo(401);
		visitor.setVisitorId(11);
		visitor.setVisitorName("Rahul");
		Mockito.when(visRepo.save(visitor)).thenReturn(visitor);
		long num= visitorService.addVisitor(visitor);
		assertEquals(101,num);
	}
	
	@Test
	void updateVisitorTest() 
	{
		VisitorEntity visitor = new VisitorEntity();
		visitor.setId(101);
		visitor.setCreatedBy("Ateeq");
		visitor.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		visitor.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		visitor.setModifiedBy("Ateeq");
		visitor.setOwnerName("Ateeq");
		visitor.setArrivalDate(LocalDate.of(2022,03,26));
		visitor.setDepartureDate(LocalDate.of(20220,03,27));
		visitor.setFlatNo(401);
		visitor.setVisitorId(121);
		visitor.setVisitorName("Ramesh");
		Mockito.when(visRepo.findById((long) 101)).thenReturn(Optional.of(visitor));
		Mockito.when(visRepo.save(visitor)).thenReturn(visitor);
		visitorService.updateVisitor(visitor);
		assertEquals("Ateeq",visitor.getOwnerName());	
	}
	@Test
	void findByPkTest() 
	{
		VisitorEntity visitor = new VisitorEntity();
		visitor.setId(101);
		visitor.setCreatedBy("Ateeq");
		visitor.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		visitor.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		visitor.setModifiedBy("Ateeq");
		visitor.setOwnerName("Ateeq");
		visitor.setArrivalDate(LocalDate.of(2022,03,26));
		visitor.setDepartureDate(LocalDate.of(20220,03,27));
		visitor.setFlatNo(401);
		visitor.setVisitorId(11);
		visitor.setVisitorName("Rahul");
		Mockito.when(visRepo.findById((long) 101)).thenReturn(Optional.of(visitor));
		VisitorEntity visEnt= visitorService.findByPk(101);
		assertEquals(101,visEnt.getId());
		assertEquals("Ateeq",visEnt.getCreatedBy());
		assertEquals("Ateeq",visEnt.getModifiedBy());
		assertEquals("Ateeq",visEnt.getOwnerName());
		assertEquals(401,visEnt.getFlatNo());
		assertEquals("Rahul",visEnt.getVisitorName());

	}
	
	
}