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

import com.cg.aps.entity.GardShiftEntity;
import com.cg.aps.entity.GardTraineeEntity;
import com.cg.aps.service.GardShiftServiceInt;

@RestController
public class GardShiftController {
	@Autowired
	GardShiftServiceInt gardShiftServ;

	// add new gard
	@PostMapping("/addgardshift")
	public ResponseEntity<Long> add(@Valid @RequestBody GardShiftEntity bean) {
		Long id = gardShiftServ.add(bean);
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}

	// search gard
	@PostMapping("/searchgard")
	public ResponseEntity<List<GardShiftEntity>> search(@RequestBody GardShiftEntity bean) {

		List<GardShiftEntity> al = gardShiftServ.search(bean);
		return new ResponseEntity<>(al, HttpStatus.OK);
	}

	// get gard bypk
	@GetMapping("/getgard/pk/{id}")
	public ResponseEntity<GardShiftEntity> findByPk(@PathVariable("id") long id) {
		return new ResponseEntity<GardShiftEntity>(gardShiftServ.findByPk(id), HttpStatus.OK);
	}

	// get by name
	@GetMapping("/getgard/name/{name}")
	public ResponseEntity<GardShiftEntity> findByName(@Valid @PathVariable("name") String name) {
		return new ResponseEntity<GardShiftEntity>(gardShiftServ.getByName(name), HttpStatus.OK);
	}

	// update gard
	@PatchMapping("/updategardshift")
	public void update(@Valid @RequestBody GardShiftEntity bean) {
		gardShiftServ.update(bean);
	}

	// delete gard
	@DeleteMapping("/deletegards")
	public void delete(@RequestBody GardShiftEntity bean) {
		gardShiftServ.delete(bean);
	}
	
	//get page
	@GetMapping("/shift/{pageNo}/{pageSize}")
	public ResponseEntity<List<GardShiftEntity>> searchPage(@PathVariable Long pageNo,
			@PathVariable Integer pageSize) {
		List<GardShiftEntity> al = gardShiftServ.search( pageNo, pageSize);
		return new ResponseEntity<>(al, HttpStatus.OK);
	

}
}
