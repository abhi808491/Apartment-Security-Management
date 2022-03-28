package com.cg.aps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.aps.entity.VehicleEntity;
import com.cg.aps.service.VehicleServiceInt;
import java.util.List;

@RestController
public class VehicleController {
	@Autowired
	VehicleServiceInt vehServ;
	
	@PostMapping("/vehicle_entity")
	ResponseEntity<Long> add(@RequestBody VehicleEntity veh) {
        long vehicle =vehServ.add(veh);
		//vehServ.add(veh);
		return new ResponseEntity<>(vehicle,HttpStatus.OK);
	}
	
	@GetMapping("/vehicle_entity/{id}")
	VehicleEntity findByPk(@PathVariable ("id")int id)
	{
		return vehServ.findByPk(id);
	}
	@GetMapping("/vehicle_entity/byname/{vehicle_name}")
	ResponseEntity<VehicleEntity> getEmpByName(@PathVariable("vehicle_name") String vehicle_name)
	{
		VehicleEntity newAtt = vehServ.findByName(vehicle_name);
         return new ResponseEntity<>(newAtt , HttpStatus.OK);
	}
	@DeleteMapping("/vehicle_entity/{id}")
	ResponseEntity<VehicleEntity>delete(@RequestBody VehicleEntity entity) {
		vehServ.delete(entity);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	@PatchMapping("/updatevehicle")
	ResponseEntity<VehicleEntity>update(@RequestBody VehicleEntity att)  {
		vehServ.update(att);
return new ResponseEntity<>( HttpStatus.OK); 	
	}
	
	@GetMapping("/vehicle_entity/entity/{page_no}/{page_size}")
	public List<VehicleEntity> search(VehicleEntity att, @PathVariable("page_no") Long page_no, @PathVariable("page_id") int page_id)
	{
		return vehServ.search(att, page_no, page_id);
	}
	
	/*@GetMapping("/vehicle_entity/entity")
	public List<VehicleEntity> search(VehicleEntity att)
	{
		return vehServ.search(att);
	}*/
	@PostMapping("/searchvehicleEntity")
	ResponseEntity<List<VehicleEntity>> search(@RequestBody VehicleEntity vehicleEntity) {
	List<VehicleEntity> domEnt = vehServ.search(vehicleEntity);
	return new ResponseEntity<>(domEnt, HttpStatus.OK);
	}
	

	@GetMapping("VehicleByFlat/{flatId}")
	ResponseEntity<List<VehicleEntity>> getVehicleByFlatId(@PathVariable("flatId") Long flatId)
	{
		List<VehicleEntity> vehEnt=vehServ.getVehicleByFlatId(flatId);
		return new ResponseEntity<>(vehEnt,HttpStatus.OK);
	}
	
}

