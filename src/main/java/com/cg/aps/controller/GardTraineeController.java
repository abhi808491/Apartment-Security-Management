package com.cg.aps.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.aps.entity.DeliveryEntity;
import com.cg.aps.entity.DomesticHelpEntity;
import com.cg.aps.entity.GardTraineeEntity;
import com.cg.aps.entity.SecurityEntity;
import com.cg.aps.entity.VisitorEntity;
import com.cg.aps.service.DeliveryServiceInt;
import com.cg.aps.service.DomesticHelpServiceInt;
import com.cg.aps.service.GardTraineeServiceInt;
import com.cg.aps.service.SecurityServiceInt;
import com.cg.aps.service.VisitorServiceInt;

@RestController
public class GardTraineeController {
	@Autowired
	GardTraineeServiceInt gardsTranningServ;

	@Autowired
	VisitorServiceInt visServ;

	@Autowired
	DomesticHelpServiceInt domesticHelpService;

	@Autowired
	DeliveryServiceInt deliveryService;

	@Autowired
	SecurityServiceInt secServ;

	// search gard
	@PostMapping("/searchgards")
	public ResponseEntity<List<GardTraineeEntity>> search(@RequestBody GardTraineeEntity gardTrainee) {
		List<GardTraineeEntity> al = gardsTranningServ.search(gardTrainee);
		return new ResponseEntity<>(al, HttpStatus.OK);
	}

	// add gard
	@PostMapping("/addgards")
	public ResponseEntity<Long> addGard(@RequestBody GardTraineeEntity gardTrainee) {
		return new ResponseEntity<Long>(gardsTranningServ.addGard(gardTrainee), HttpStatus.OK);
	}

	// get gards by PK
	@GetMapping("/getgards/id/{id}")
	public ResponseEntity<GardTraineeEntity> findByPk(@PathVariable("id") long id) {
		return new ResponseEntity<GardTraineeEntity>(gardsTranningServ.findByPk(id), HttpStatus.OK);
	}

	// get gards by name
	@GetMapping("/getgards/name/{name}")
	public ResponseEntity<GardTraineeEntity> getByName(@Valid @PathVariable("name") String name) {
		return new ResponseEntity<GardTraineeEntity>(gardsTranningServ.getByName(name), HttpStatus.OK);
	}

	// update gards
	@PatchMapping("/updategards")
	public void update(@Valid @RequestBody GardTraineeEntity gardTrainee) {
		gardsTranningServ.update(gardTrainee);

	}

	// delete gards
	@DeleteMapping("/gards")
	public void delete(@RequestBody GardTraineeEntity gardTrainee) {
		gardsTranningServ.delete(gardTrainee);
	}

	// get page

	@PostMapping("/gard/{pageNo}/{pageSize}")
	public ResponseEntity<List<GardTraineeEntity>> searchPage(@PathVariable Long pageNo,
			@PathVariable Integer pageSize) {
		List<GardTraineeEntity> al = gardsTranningServ.search(pageNo, pageSize);
		return new ResponseEntity<>(al, HttpStatus.OK);
	}

	// get gard using shift id by relationship
	@GetMapping("/getGardByShift/{id}")
	public ResponseEntity<List<GardTraineeEntity>> getAllGardTraineeByShiftId(@PathVariable("id") long id) {
		return new ResponseEntity<>(gardsTranningServ.getAllGardTraineeByShiftId(id), HttpStatus.OK);
	}

	// get gard using salary id by relationship
	@GetMapping("/getGardBySalary/{id}")
	public ResponseEntity<GardTraineeEntity> getGardBySalaryId(long id) {
		return new ResponseEntity<GardTraineeEntity>(gardsTranningServ.getGardBySalaryId(id), HttpStatus.OK);
	}

	// map gard salary with gardTrainee
	@GetMapping("/mapsalary/{gardPk}/{salaryPk}")
	public GardTraineeEntity mapSalary(@PathVariable long gardPk, @PathVariable long salaryPk) {
		return gardsTranningServ.mapSalary(gardPk, salaryPk);
	}

	// map gard shift with gardTrainee
	@GetMapping("/mapShift/{gardPk}/{shiftPk}")
	public GardTraineeEntity mapShift(@PathVariable long gardPk, @PathVariable long shiftPk) {
		return gardsTranningServ.mapShift(gardPk, shiftPk);
	}

	// get visitor using gard id
	@GetMapping("getvisitorByGardId/{gardId}")
	ResponseEntity<List<VisitorEntity>> getVisitorByGardId(@PathVariable("gardId") Long gardId) {
		List<VisitorEntity> lis = visServ.getVisitorByGardId(gardId);
		return new ResponseEntity<>(lis, HttpStatus.OK);
	}

	// find domesticHelpList By guardId
	@GetMapping("getdomesticHelpListByguard/{gardId}")
	ResponseEntity<List<DomesticHelpEntity>> getDomesticHelpByGuardId(@PathVariable("gardId") Long gardId) {
		List<DomesticHelpEntity> domEnt = domesticHelpService.getDomesticHelpByGuardId(gardId);
		return new ResponseEntity<>(domEnt, HttpStatus.OK);

	}

	// find deliveryList By guardId
	@GetMapping("getdeliveryListBygard/{gardId}")
	ResponseEntity<List<DeliveryEntity>> getDeliveriesByGardId(@PathVariable("gardId") Long gardId) {
		List<DeliveryEntity> delEnt = deliveryService.getDeliveryListByGuardId(gardId);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);

	}

	// get security using gard id
	@GetMapping("getSecurityByGard/{gardId}")
	ResponseEntity<List<SecurityEntity>> getSecurityByGardId(@PathVariable("gardId") Long gardId) {
		List<SecurityEntity> lis = secServ.getSecurityByGard(gardId);
		return new ResponseEntity<>(lis, HttpStatus.OK);

	}

}
