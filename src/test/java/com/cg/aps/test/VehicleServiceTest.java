package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.aps.entity.VehicleEntity;
import com.cg.aps.service.VehicleServiceInt;
@SpringBootTest
public class VehicleServiceTest {
	@Autowired
	VehicleServiceInt vehService;
	@Test
	@Disabled
	void addTest() {
		VehicleEntity veh=new VehicleEntity();
		veh.setId(20);
		veh.setCreatedBy("rizwan");
		veh.setModifiedBy("rizwan");
		veh.setVehicle_name("MT200");
		veh.setArrivalTime("9:30");
		veh.setDepartureTime("10:00");
		veh.setParkingNo("H12");
		veh.setVehicleType("Racing");
		veh.setVehicleNo("TSG1123");
		long num=vehService.add(veh);
		assertEquals(num,veh.getId());
		//vehService.add(veh);
		//VehicleEntity veh1=vehService.findByPk(15);
		//assertEquals("MT200",veh1.getVehicle_name());
		//assertEquals("TSG1123",veh1.getVehicleNo());
		}

	
      @Test
      //@Disabled
      void findByNameTest() {
    	  VehicleEntity veh1=vehService.findByName("Bullet");
    	  assertEquals(4,veh1.getId());
    	  assertEquals("TS11T5678",veh1.getVehicleNo());
    	  
      }
      
      @Test
      //@Disabled
      void updateTest() {
    	  VehicleEntity veh1=new VehicleEntity();
    	  veh1.setId(22);
    	  veh1.setVehicle_name("Ninja");
    	  veh1.setVehicleNo("US123");
    	  vehService.update(veh1);
    	  VehicleEntity veh= vehService.findByPk(22);
    	  assertEquals("US123",veh.getVehicleNo());
    	  assertEquals("Ninja",veh.getVehicle_name());
    	  
      }
      @Test
      //@Disabled
      void findByPkTest() {
    	  VehicleEntity veh=vehService.findByPk(4);
    	  assertEquals("Bullet",veh.getVehicle_name());
    	  assertEquals("TS11T5678",veh.getVehicleNo());
    	  
    			  }
      @Test
      @Disabled
      void deleteTest() {
    	  VehicleEntity veh=vehService.findByPk(20);
    	  if(veh!=null) {
    		  assertEquals("MT200",veh.getVehicle_name());
    		  assertEquals("TSG1123",veh.getVehicleNo());
    		  vehService.delete(veh);
    		  
    	  }
    	  
      }
    	  
}
