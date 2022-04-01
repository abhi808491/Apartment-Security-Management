package com.cg.aps.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	ResponseEntity<Long> add(@Valid @RequestBody DeliveryEntity deliveryEntity) {
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
	@PutMapping("/updateDelivery")
	ResponseEntity<DeliveryEntity> update(@Valid @RequestBody DeliveryEntity deliveryEntity) {
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

	// find deliveryList By FlatId
	@GetMapping("deliveryListByFlat/{flatId}")
	ResponseEntity<List<DeliveryEntity>> getDeliveriesByFlatId(@PathVariable("flatId") Long flatId) {
		List<DeliveryEntity> delEnt = deliveryService.getDeliveryListByFlatId(flatId);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);

	}

	// find deliveryList By userId
	@GetMapping("deliveryListByUser/{userId}")
	ResponseEntity<List<DeliveryEntity>> getDeliveriesByUserId(@PathVariable("userId") Long userId) {
		List<DeliveryEntity> delEnt = deliveryService.getDeliveryListByUserId(userId);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);

	}


	// add flat to delivery
	@GetMapping("mapflattodelivery/{deliveryId}/{flatId}")
	ResponseEntity<DeliveryEntity> mapDeliveytoFlat(@PathVariable("deliveryId") Long deliveryId,
			@PathVariable("flatId") Long flatId) {
		return new ResponseEntity<>(deliveryService.mapDeliveryToFlat(deliveryId, flatId), HttpStatus.OK);
	}

	// add guard to delivery
	@GetMapping("mapguardtodelivery/{deliveryId}/{guardId}")
	ResponseEntity<DeliveryEntity> mapDeliveytoguard(@PathVariable("deliveryId") Long deliveryId,
			@PathVariable("guardId") Long guardId) {
		return new ResponseEntity<>(deliveryService.mapDeliveryToGuard(deliveryId, guardId), HttpStatus.OK);
	}

}