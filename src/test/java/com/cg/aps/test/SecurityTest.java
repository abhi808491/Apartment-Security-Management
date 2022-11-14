package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.aps.entity.SecurityEntity;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.SecurityServiceInt;

@SpringBootTest
public class SecurityTest {

	@Autowired
	SecurityServiceInt secServ;
	
	@Test
	void addTest() 
	{
		SecurityEntity security= new SecurityEntity();
		security.setId(1);
		security.setCreatedBy("Ateeq");
		security.setModifiedBy("Ateeq");
		security.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		security.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		security.setAlert("Car outside");
		security.setMessage("Open Gate");
		long n = secServ.add(security);
		assertEquals(n,security.getId());			
}
	@Test
	void updateTest() 
	{
		SecurityEntity security= new SecurityEntity();
		security.setId(1);
		security.setCreatedBy("Ateeq");
		security.setModifiedBy("Ateeq");
		security.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		security.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		security.setAlert("no car outside");
		security.setMessage("close Gate");
		secServ.update(security);
		SecurityEntity newsecurity= secServ.findByPk(1);
		assertEquals(1,security.getId());
		assertEquals("Ateeq", newsecurity.getCreatedBy());
		assertEquals("Ateeq", newsecurity.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"), newsecurity.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"), newsecurity.getModifiedDateTime());
		assertEquals("no car outside", newsecurity.getAlert());
		assertEquals("close Gate", newsecurity.getMessage());	
	}
	@Test
	void findByPkTest() 
	{
		SecurityEntity security = secServ.findByPk(130);
		assertEquals(130,security.getId());
		assertEquals("Ateeq",security.getCreatedBy());
		assertEquals("Ateeq",security.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"),security.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"),security.getModifiedDateTime());
		assertEquals("no car outside",security.getAlert());
		assertEquals("close gate",security.getMessage());
	}
	
	@Test
	public void DeleteTest() throws RecordNotFoundException{
		SecurityEntity security= new SecurityEntity();
		security.setId(30);
		security.setCreatedBy("Ateeq");
		security.setModifiedBy("Ateeq");
		security.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		security.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-26 14:36:09.596"));
		security.setAlert("no car outside");
		security.setMessage("close gate");
		secServ.add(security);
		secServ.delete(security);
		assertThrows(RecordNotFoundException.class, ()->{
			secServ.findByPk(security.getId());
			});
	}
	
}
