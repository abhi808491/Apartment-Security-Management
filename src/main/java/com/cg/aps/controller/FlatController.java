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

import com.cg.aps.entity.FlatEntity;
import com.cg.aps.service.FlatServiceInt;

@RestController
public class FlatController {
	@Autowired
	FlatServiceInt flatServ;
	
	// search flat
		@PostMapping("/searchflats")
		public ResponseEntity<List<FlatEntity>> search(@RequestBody FlatEntity bean) {
			List<FlatEntity> al = flatServ.search(bean);
			return new ResponseEntity<>(al, HttpStatus.OK);
		}

		// add flat
		@PostMapping("/addflats")
		public ResponseEntity<Long> add(@Valid @RequestBody FlatEntity bean) {
			Long id = flatServ.add(bean);
			return new ResponseEntity<Long>(id, HttpStatus.OK);
		}

		// get flat by PK
		@GetMapping("/getflats/id/{id}")
		public ResponseEntity<FlatEntity> findByPk(@PathVariable("id") long id) {
			return new ResponseEntity<FlatEntity>(flatServ.findByPk(id), HttpStatus.OK);
		}

		// get flats by name
		@GetMapping("/getflats/name/{name}")
		public ResponseEntity<FlatEntity> getByOwnerName(@Valid @PathVariable("name") String name) {
			return new ResponseEntity<FlatEntity>(flatServ.findByOwnerName(name), HttpStatus.OK);
		}

		// update flats
		@PatchMapping("/updateflats")
		public void update(@Valid @RequestBody FlatEntity bean) {
			flatServ.update(bean);

		}

		// delete flats
		@DeleteMapping("/flats")
		public void delete(@RequestBody FlatEntity bean) {
			flatServ.delete(bean);
		}
		
		//get page
		
		@PostMapping("/flat/{pageNo}/{pageSize}")
		public ResponseEntity<List<FlatEntity>> getDeliveries(@PathVariable Integer pageNo,@PathVariable Integer pageSize,@RequestBody FlatEntity bean){
			List<FlatEntity> al= flatServ.search(bean,pageNo,pageSize);
			return new ResponseEntity<>(al,HttpStatus.OK);
		}
		
		// get flat by rent ID
		@GetMapping("/getflatsbyRentId/{id}")
		public ResponseEntity<FlatEntity> getFlatByRent(@PathVariable("id") long id) {
			return new ResponseEntity<FlatEntity>(flatServ.getFlatByRent(id), HttpStatus.OK);
		}
		
		// get flat by user ID
		@GetMapping("/getflatsbyUserId/{id}")
		public ResponseEntity<FlatEntity> getFlatByUser(@PathVariable("id") long id) {
			return new ResponseEntity<FlatEntity>(flatServ.getFlatByUser(id), HttpStatus.OK);
		}
}
