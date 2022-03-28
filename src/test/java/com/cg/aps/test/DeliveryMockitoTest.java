package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.aps.entity.DeliveryEntity;
import com.cg.aps.repository.DeliveryDAOInt;
import com.cg.aps.service.DeliveryService;
import com.cg.aps.service.DeliveryServiceInt;

@ExtendWith(SpringExtension.class)
public class DeliveryMockitoTest {
	@InjectMocks
	DeliveryService deliveryService;
	@MockBean
	DeliveryDAOInt deliveryDAOInt;
	@BeforeEach
	void init()
	{
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void addTest() 
	{
		DeliveryEntity delivery=new DeliveryEntity();
		delivery.setId(1);
		delivery.setCreatedBy("rishitha");
		delivery.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-25 13:55:02.32"));
		delivery.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-25 13:55:02.32"));
		delivery.setDate(java.sql.Timestamp.valueOf("2022-03-26 13:55:02.32"));
		delivery.setModifiedBy("rishitha");
		delivery.setOwnerName("Ramesh");
		delivery.setStatus("delivered");
		delivery.setTime("7:00 AM");
		Mockito.when(deliveryDAOInt.save(delivery)).thenReturn(delivery);
		long num=deliveryService.add(delivery);
		assertEquals(1,num);	
	}
	@Test
	void updateTest() 
	{
		
		DeliveryEntity delivery=new DeliveryEntity();
		delivery.setId(1);
		delivery.setCreatedBy("rishitha");
		delivery.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedBy("rishitha");
		delivery.setOwnerName("Ravi");
		delivery.setStatus("delivered");
		delivery.setTime("7:00 AM");
		Mockito.when(deliveryDAOInt.findById((long) 1)).thenReturn(Optional.of(delivery));
		Mockito.when(deliveryDAOInt.save(delivery)).thenReturn(delivery);
		deliveryService.update(delivery);
		assertEquals("Ravi",delivery.getOwnerName());	
	}
	@Test
	void findByNameTest() 
	{
		List<DeliveryEntity> deliveryList=new ArrayList();
		DeliveryEntity delivery=new DeliveryEntity();
		delivery.setId(100000);
		delivery.setCreatedBy("rishitha");
		delivery.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedBy("rishitha");
		delivery.setOwnerName("Ramesh");
		delivery.setStatus("delivered");
		delivery.setTime("7:00 AM");
		deliveryList.add(delivery);
		Mockito.when(deliveryDAOInt.findByOwnerName("Ramesh")).thenReturn(deliveryList);
		List<DeliveryEntity> delEnt=deliveryService.findByName("Ramesh");
		assertEquals(1,delEnt.size());
	}
	@Test
	void findByPkTest() 
	{
		DeliveryEntity delivery=new DeliveryEntity();
		delivery.setId(1);
		delivery.setCreatedBy("rishitha");
		delivery.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedBy("rishitha");
		delivery.setOwnerName("Ramesh");
		delivery.setStatus("delivered");
		delivery.setTime("7:00 AM");
		Mockito.when(deliveryDAOInt.findById((long) 1)).thenReturn(Optional.of(delivery));
		DeliveryEntity delEnt=deliveryService.findByPk(1);
		assertEquals(1,delEnt.getId());
		assertEquals("rishitha",delEnt.getCreatedBy());
		assertEquals("rishitha",delEnt.getModifiedBy());
		assertEquals("Ramesh",delEnt.getOwnerName());
		assertEquals("delivered",delEnt.getStatus());
		assertEquals("7:00 AM",delEnt.getTime());
	}
	
	@Test
	void deleteTest()
	{
		DeliveryEntity delivery=new DeliveryEntity();
		delivery.setId(1);
		delivery.setCreatedBy("rishitha");
		delivery.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedBy("rishitha");
		delivery.setOwnerName("Ramesh");
		delivery.setStatus("delivered");
		delivery.setTime("7:00 AM");
		Mockito.when(deliveryDAOInt.findById((long) 1)).thenReturn(Optional.of(delivery));
		Mockito.doNothing().when(deliveryDAOInt).delete(delivery);
		deliveryService.delete(delivery);
	}
	

}
