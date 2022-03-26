package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.cg.aps.entity.DomesticHelpEntity;
import com.cg.aps.repository.DomesticHelpDAOInt;
import com.cg.aps.service.DomesticHelpService;
import com.cg.aps.service.DomesticHelpServiceInt;

@ExtendWith(SpringExtension.class)
public class DomesticHelpMockitoTest {
	@InjectMocks
	DomesticHelpService domesticService;
	@MockBean
	DomesticHelpDAOInt domesticHelpDAOInt;
	@BeforeEach
	void init()
	{
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void addDeliveryTest() throws ParseException
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
		Mockito.when(domesticHelpDAOInt.save(domesticHelp)).thenReturn(domesticHelp);
		long num=domesticService.add(domesticHelp);
		assertEquals(1,num);	
	}
	@Test
	void updateDeliveryTest() throws ParseException
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
		Mockito.when(domesticHelpDAOInt.findById((long) 1)).thenReturn(Optional.of(domesticHelp));
		Mockito.when(domesticHelpDAOInt.save(domesticHelp)).thenReturn(domesticHelp);
		domesticService.update(domesticHelp);
		assertEquals("Ramesh",domesticHelp.getOwnerName());	
	}
	@Test
	void findByNameTest() throws ParseException
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
		Mockito.when(domesticHelpDAOInt.findByOwnerName("Ramesh")).thenReturn(domesticHelp);
		DomesticHelpEntity delEnt=domesticService.findByName("Ramesh");
		assertEquals("Ramesh",delEnt.getOwnerName());
	}
	@Test
	void findByPkTest() throws ParseException
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
		Mockito.when(domesticHelpDAOInt.findById((long) 1)).thenReturn(Optional.of(domesticHelp));
		DomesticHelpEntity delEnt=domesticService.findByPk(1);
		assertEquals(1,delEnt.getId());
		assertEquals("rishitha",delEnt.getCreatedBy());
		assertEquals("rishitha",delEnt.getModifiedBy());
		assertEquals("Ramesh",delEnt.getOwnerName());
		assertEquals("300B",delEnt.getFlatNo());
		assertEquals("cooking",delEnt.getHelpType());
	}
	
	
	


}
