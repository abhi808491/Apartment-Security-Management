package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.aps.entity.DeliveryEntity;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.DeliveryServiceInt;

@SpringBootTest
public class DeliveryTest {
	@Autowired
	DeliveryServiceInt deliveryServ;
	@Test
	void addTest() 
	{
		DeliveryEntity delivery=new DeliveryEntity();
		delivery.setId(130);
		delivery.setCreatedBy("rishitha");
		delivery.setModifiedBy("rishitha");
		delivery.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setOwnerName("Ramesh");
		delivery.setStatus("delivered");
		delivery.setTime("7:00 AM");
		long num=deliveryServ.add(delivery);
		assertEquals(num,delivery.getId());	
		
	}
	@Test
	void updateTest() 
	{
		DeliveryEntity delivery=new DeliveryEntity();
		delivery.setId(130);
		delivery.setCreatedBy("rishitha");
		delivery.setModifiedBy("rishitha");
		delivery.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setOwnerName("Ravi");
		delivery.setStatus("not delivered");
		delivery.setTime("7:00 AM");
		deliveryServ.update(delivery);
		DeliveryEntity newDelivery=deliveryServ.findByPk(130);
		assertEquals(130,delivery.getId());
		assertEquals("rishitha", newDelivery.getCreatedBy());
		assertEquals("rishitha", newDelivery.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"), newDelivery.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"), newDelivery.getModifiedDateTime());
		assertEquals("Ravi", newDelivery.getOwnerName());
		assertEquals("not delivered", newDelivery.getStatus());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"), newDelivery.getDate());
		assertEquals("7:00 AM", newDelivery.getTime());
		
	}
	
	@Test
	void findByPkTest() 
	{
		DeliveryEntity delivery=deliveryServ.findByPk(130);
		assertEquals(130,delivery.getId());
		assertEquals("rishitha",delivery.getCreatedBy());
		assertEquals("rishitha",delivery.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"),delivery.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"),delivery.getModifiedDateTime());
		assertEquals("Ravi",delivery.getOwnerName());
		assertEquals("not delivered",delivery.getStatus());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"),delivery.getDate());
		assertEquals("7:00 AM",delivery.getTime());
	}
	@Test
	void findByNameTest() 
	{
		DeliveryEntity delivery=deliveryServ.findByName("rahul");
		assertEquals(1,delivery.getId());
		assertEquals("rishitha",delivery.getCreatedBy());
		assertEquals("rishitha",delivery.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-25 13:44:47.14"),delivery.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf(" 2022-03-25 13:44:47.14"),delivery.getModifiedDateTime());
		assertEquals(java.sql.Timestamp.valueOf(" 2022-03-23 13:44:47.14"),delivery.getDate());
		assertEquals("rahul",delivery.getOwnerName());
		assertEquals("delivered",delivery.getStatus());
		assertEquals("7:00 AM",delivery.getTime());
	}
	@Test
	public void DeleteTest() throws RecordNotFoundException{
		DeliveryEntity delivery=new DeliveryEntity();
		delivery.setId(30);
		delivery.setCreatedBy("rishitha");
		delivery.setModifiedBy("rishitha");
		delivery.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setOwnerName("Ravi");
		delivery.setStatus("not delivered");
		delivery.setTime("7:00 AM");
		deliveryServ.add(delivery);
		deliveryServ.delete(delivery);
		assertThrows(RecordNotFoundException.class, ()->{
			deliveryServ.findByPk(delivery.getId());
			});
	}
	

}
