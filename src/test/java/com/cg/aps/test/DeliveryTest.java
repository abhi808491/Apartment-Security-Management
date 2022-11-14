package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

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
	void addTest() {
		DeliveryEntity delivery = new DeliveryEntity();
		delivery.setId(130);
		delivery.setCreatedBy("rishitha");
		delivery.setModifiedBy("rishitha");
		delivery.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setOwnerName("Ramesh");
		delivery.setStatus("delivered");
		delivery.setTime("7:00 AM");
		long num = deliveryServ.add(delivery);
		assertEquals(num, delivery.getId());

	}

	@Test
	void updateTest() {
		DeliveryEntity delivery = new DeliveryEntity();
		delivery.setId(38);
		delivery.setCreatedBy("rishitha");
		delivery.setModifiedBy("rishitha");
		delivery.setCreatedDateTime(java.sql.Timestamp.valueOf(" 2022-03-30 09:25:18.467"));
		delivery.setModifiedDateTime(java.sql.Timestamp.valueOf(" 2022-03-30 09:25:18.467"));
		delivery.setDate(java.sql.Timestamp.valueOf("2022-03-30 09:25:18.467"));
		delivery.setOwnerName("Mark");
		delivery.setStatus("delivered");
		delivery.setTime("11:00 AM");
		deliveryServ.update(delivery);
		DeliveryEntity newDelivery = deliveryServ.findByPk(38);
		assertEquals(38, delivery.getId());
		assertEquals("rishitha", newDelivery.getCreatedBy());
		assertEquals("rishitha", newDelivery.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-30 09:25:18.467"), newDelivery.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-30 09:25:18.467"), newDelivery.getModifiedDateTime());
		assertEquals("Mark", newDelivery.getOwnerName());
		assertEquals("delivered", newDelivery.getStatus());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-30 09:25:18.467"), newDelivery.getDate());
		assertEquals("11:00 AM", newDelivery.getTime());

	}

	@Test
	void findByPkTest() {
		DeliveryEntity delivery = deliveryServ.findByPk(37);
		assertEquals(37, delivery.getId());
		assertEquals("rishitha", delivery.getCreatedBy());
		assertEquals("rishitha", delivery.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-30 09:25:18.467"), delivery.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-30 09:25:18.467"), delivery.getModifiedDateTime());
		assertEquals("john", delivery.getOwnerName());
		assertEquals("not delivered", delivery.getStatus());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-30 09:25:18.467"), delivery.getDate());
		assertEquals("7:00 A M", delivery.getTime());
	}

	@Test
	void findByNameTest() {
		List<DeliveryEntity> delivery = deliveryServ.findByName("david");
		assertEquals(1, delivery.size());

	}

	@Test
	public void DeleteTest() throws RecordNotFoundException {
		DeliveryEntity delivery = deliveryServ.findByPk(130);
		deliveryServ.delete(delivery);
		assertThrows(RecordNotFoundException.class, () -> {
			deliveryServ.findByPk(delivery.getId());
		});
	}

	@Test
	void searchTest() {
		DeliveryEntity delivery = new DeliveryEntity();
		delivery.setId(38);
		delivery.setCreatedBy("rishitha");
		delivery.setModifiedBy("rishitha");
		delivery.setCreatedDateTime(java.sql.Timestamp.valueOf(" 2022-03-30 09:25:18.467"));
		delivery.setModifiedDateTime(java.sql.Timestamp.valueOf(" 2022-03-30 09:25:18.467"));
		delivery.setDate(java.sql.Timestamp.valueOf("2022-03-30 09:25:18.467"));
		delivery.setOwnerName("Mark");
		delivery.setStatus("delivered");
		delivery.setTime("11:00 AM");
		List<DeliveryEntity> newDelivery = deliveryServ.search(delivery);
		assertEquals(1, newDelivery.size());
	}

	@Test
	void getDeliveryListByUserIdTest() {
		List<DeliveryEntity> returnedDeliveryList = deliveryServ.getDeliveryListByUserId(1);
		assertEquals(3, returnedDeliveryList.size());
	}

	@Test
	void getDeliveryListByFlatIdTest() {
		List<DeliveryEntity> returnedDeliveryList = deliveryServ.getDeliveryListByFlatId(11);
		assertEquals(3, returnedDeliveryList.size());
	}

}
