package com.cg.aps.controller;

import java.util.List;

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
import com.cg.aps.entity.DeliveryEntity;
import com.cg.aps.service.DeliveryServiceInt;

@RestController
public class DeliveryController {
	@Autowired
	DeliveryServiceInt deliveryService;

	// add DeliveryEntity
	@PostMapping("/addDelivery")
	ResponseEntity<Long> add(@RequestBody DeliveryEntity deliveryEntity) {
		long delEnt = deliveryService.add(deliveryEntity);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);
	}

	// find deliveryEntity by Name
	@GetMapping("/delivery/byName/{name}")
	ResponseEntity<List<DeliveryEntity>> findByName(@PathVariable("name") String name) {
		List<DeliveryEntity> delEnt = deliveryService.findByName(name);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);
	}

	// delete deliverEntity
	@DeleteMapping("/deleteDelivery")
	ResponseEntity<DeliveryEntity> delete(@RequestBody DeliveryEntity deliveryEntity) {
		deliveryService.delete(deliveryEntity);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// update deliverEntity
	@PostMapping("/updateDelivery")
	ResponseEntity<DeliveryEntity> update(@RequestBody DeliveryEntity deliveryEntity) {
		deliveryService.update(deliveryEntity);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// find deliveryEntity by Id
	@GetMapping("/delivery/{id}")
	ResponseEntity<DeliveryEntity> findByPk(@PathVariable("id") int empId) {
		return new ResponseEntity<>(deliveryService.findByPk(empId), HttpStatus.OK);

	}

	// search deliveryEntity
	@PostMapping("/searchdelivery")
	ResponseEntity<List<DeliveryEntity>> search(@RequestBody DeliveryEntity deliveryEntity) {
		List<DeliveryEntity> delEnt = deliveryService.search(deliveryEntity);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);
	}

	// search by pageNo and PageSize
	@GetMapping("deliveryByNoAndSize/{pageNo}/{pageSize}")
	ResponseEntity<List<DeliveryEntity>> search(@PathVariable("pageNo") Long pageNo,
			@PathVariable("pageSize") Integer pageSize) {
		List<DeliveryEntity> delEnt = deliveryService.search(pageNo, pageSize);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);
	}
	//find deliveries of Flat
	@GetMapping("deliveriesByFlat/{flatId}")
	ResponseEntity<List<DeliveryEntity>> getDeliveriesByFlatId(@PathVariable("flatId") Long flatId)
	{
		List<DeliveryEntity> delEnt=deliveryService.getDeliveriesByFlatId(flatId);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);
		
	}
	
	//find deliveries By guard
	@GetMapping("deliveriesByguard/{guardId}")
	ResponseEntity<List<DeliveryEntity>> getDeliveriesByguardId(@PathVariable("guardId") Long guardId)
	{
		List<DeliveryEntity> delEnt=deliveryService.getDeliveryListByGuardId(guardId);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);
			
		}
	
	
}