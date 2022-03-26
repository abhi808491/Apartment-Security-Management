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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.cg.aps.entity.VehicleEntity;
import com.cg.aps.repository.VehicleRepository;
import com.cg.aps.service.VehicleService;
@SpringBootTest

public class VehicleServiceMockitoTest {
	@InjectMocks
	VehicleService vehService;
	@MockBean
	VehicleRepository vehRepo;
	@BeforeEach
	void init()
	{
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void addVehicleTest() throws ParseException
	{
		VehicleEntity d=new VehicleEntity();
		d.setId(1);
		d.setCreatedBy("rizwan");
		d.setCreatedDateTime(java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0"));
		d.setModifiedDateTime(java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0"));
		d.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2022"));
		d.setModifiedBy("rizwan");
		d.setVehicle_name("ninja");
		d.setParkingNo("B12");
		d.setVehicleNo("AP22T5678");
		Mockito.when(vehRepo.save(d)).thenReturn(d);
		long vehicle=vehService.add(d);
		assertEquals(1,vehicle);	
	}
	@Test
	void updateVehicleTest() throws ParseException
	{
		VehicleEntity d=new VehicleEntity();
		d.setId(1);
		d.setCreatedBy("rizwan");
		d.setCreatedDateTime(java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0"));
		d.setModifiedDateTime(java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0"));
		d.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2022"));
		d.setModifiedBy("rizwan");
		d.setVehicle_name("ninja");
		d.setParkingNo("B12");
		d.setVehicleNo("AP22T5678");
		
		Mockito.when(vehRepo.findById((long) 1)).thenReturn(Optional.of(d));
		Mockito.when(vehRepo.save(d)).thenReturn(d);
		vehService.update(d);
		assertEquals("ninja",d.getVehicle_name());	
	}
	@Test
	void findByVehicle_name() throws ParseException
	{
		VehicleEntity d=new VehicleEntity();
		d.setId(1);;
		d.setCreatedBy("rizwan");
		d.setCreatedDateTime(java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0"));
		d.setModifiedDateTime(java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0"));
		d.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2022"));
		d.setModifiedBy("rizwan");
		d.setVehicle_name("ninja");
		d.setParkingNo("B12");
		d.setVehicleNo("AP22T5678");
		Mockito.when(vehRepo.findByAttName("ninja")).thenReturn(d);
		VehicleEntity vehEnt=vehService.findByName("ninja");
		assertEquals("ninja",vehEnt.getVehicle_name());
	}
	@Test
	void findByPkTest() throws ParseException
	{
		com.cg.aps.entity.VehicleEntity d=new VehicleEntity();
		d.setId(1);
		d.setCreatedBy("rizwan");
		d.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		d.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		d.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2022"));
		d.setModifiedBy("rizwan");
		d.setVehicle_name("ninja");
		d.setParkingNo("B12");
		d.setVehicleNo("AP22T5678");
		Mockito.when(vehRepo.findById((long) 1)).thenReturn(Optional.of(d));
		VehicleEntity vehEnt=vehService.findByPk(1);
		assertEquals(1,vehEnt.getId());
	}
	
	

}




