package com.cg.aps.controller;

import java.util.List;

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
import com.cg.aps.entity.DomesticHelpEntity;
import com.cg.aps.service.DomesticHelpServiceInt;

@RestController
public class DomesticHelpController {
	@Autowired
	DomesticHelpServiceInt domesticHelpService;

	@PostMapping("/addDomesticHelp")
	ResponseEntity<Long> add(@RequestBody DomesticHelpEntity domesticHelp) {
		long domHelpEnt = domesticHelpService.add(domesticHelp);
		return new ResponseEntity<>(domHelpEnt, HttpStatus.OK);
	}

	// find DomesticHelpEntity by name
	@GetMapping("/domesticHelp/byName/{name}")
	ResponseEntity<List<DomesticHelpEntity>> getEmpByName(@PathVariable("name") String name) {
		List<DomesticHelpEntity> domHelpEnt = domesticHelpService.findByName(name);
		return new ResponseEntity<>(domHelpEnt, HttpStatus.OK);
	}

	// delete DomesticHelpEntity
	@DeleteMapping("/domesticHelp/{id}")
	ResponseEntity<DomesticHelpEntity> delete(@RequestBody DomesticHelpEntity domesticHelpEntity) {
		domesticHelpService.delete(domesticHelpEntity);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// update DomesticHelpEntity
	@PutMapping("/updateDomesticHelp")
	ResponseEntity<DomesticHelpEntity> update(@RequestBody DomesticHelpEntity domesticHelpEntity) {
		domesticHelpService.update(domesticHelpEntity);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// find DomesticHelpEntity by Id
	@GetMapping("/domesticHelp/{id}")
	ResponseEntity<DomesticHelpEntity> findByPk(@PathVariable("id") int id) {
		return new ResponseEntity<>(domesticHelpService.findByPk(id), HttpStatus.OK);
	}

	// search DomesticHelpEntity
	@PostMapping("/searchDomesticHelp")
	ResponseEntity<List<DomesticHelpEntity>> search(@RequestBody DomesticHelpEntity domesticHelpEntity) {
		List<DomesticHelpEntity> domEnt = domesticHelpService.search(domesticHelpEntity);
		return new ResponseEntity<>(domEnt, HttpStatus.OK);
	}

	// search by pageNo and PageSize
	@GetMapping("domesticHelpByNoAndSize/{pageNo}/{pageSize}")
	ResponseEntity<List<DomesticHelpEntity>> search(@PathVariable("pageNo") Long pageNo,
			@PathVariable("pageSize") Integer pageSize) {
		List<DomesticHelpEntity> domEnt = domesticHelpService.search(pageNo, pageSize);
		return new ResponseEntity<>(domEnt, HttpStatus.OK);
	}

	// add guard to domesticHelp
	@GetMapping("mapguardtodomesticHelp/{domesticHelpId}/{guardId}")
	ResponseEntity<DomesticHelpEntity> mapDomesticHelptoguard(@PathVariable("domesticHelpId") Long domesticHelpId,
			@PathVariable("guardId") Long guardId) {
		return new ResponseEntity<>(domesticHelpService.mapDomesticHelpToGuard(domesticHelpId, guardId), HttpStatus.OK);
	}


}
