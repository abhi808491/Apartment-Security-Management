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

import com.cg.aps.entity.GardSalaryEntity;
import com.cg.aps.entity.GardShiftEntity;
import com.cg.aps.service.GardSalaryServiceInt;

@RestController
public class GardSalaryController {
	@Autowired
	GardSalaryServiceInt gardSalaryServ;

	// search gard
	@PostMapping("/getgards")
	public ResponseEntity<List<GardSalaryEntity>> search(@RequestBody GardSalaryEntity bean) {
		List<GardSalaryEntity> al = gardSalaryServ.search(bean);
		return new ResponseEntity<>(al, HttpStatus.OK);
	}

	// add gards
	@PostMapping("/addgard")
	public ResponseEntity<Long> add(@Valid @RequestBody GardSalaryEntity bean) {
		Long id = gardSalaryServ.add(bean);
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}

	// get gard by PK
	@GetMapping("/getgardsbyId/{id}")
	public ResponseEntity<GardSalaryEntity> findByPk(@PathVariable("id") long id) {
		return new ResponseEntity<GardSalaryEntity>(gardSalaryServ.findByPk(id), HttpStatus.OK);
	}

	// get gards by name
	@GetMapping("/getgardsbyname/{name}")
	public ResponseEntity<GardSalaryEntity> getByName(@PathVariable("name") String name) {
		return new ResponseEntity<GardSalaryEntity>(gardSalaryServ.findByName(name), HttpStatus.OK);
	}

	// update gards
	@PatchMapping("/updategard")
	public void update(@Valid @RequestBody GardSalaryEntity bean) {
		gardSalaryServ.update(bean);
	}

	// delete gards
	@DeleteMapping("/deletegard")
	public void delete(@RequestBody GardSalaryEntity bean) {
		gardSalaryServ.delete(bean);
	}

	// get page
	@GetMapping("/salary/{pageNo}/{pageSize}")
	public ResponseEntity<List<GardSalaryEntity>> searchPage(@PathVariable Long pageNo,
			@PathVariable Integer pageSize) {
		List<GardSalaryEntity> al = gardSalaryServ.search(pageNo, pageSize);
		return new ResponseEntity<>(al, HttpStatus.OK);
	}
}
