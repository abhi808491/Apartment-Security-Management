package com.cg.aps.controller;
import org.springframework.http.ResponseEntity;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.aps.entity.FlatRentEntity;
import com.cg.aps.service.FlatRentServiceInt;

@RestController
public class FlatRentController {
	@Autowired
	FlatRentServiceInt flatrentServ;
	
	// search flat
			@PostMapping("/searchflatsrent")
			public ResponseEntity<List<FlatRentEntity>> search(@RequestBody FlatRentEntity bean) {
				List<FlatRentEntity> al = flatrentServ.search(bean);
				return new ResponseEntity<>(al, HttpStatus.OK);
			}

			// add flat
			@PostMapping("/addflatsrent")
			public ResponseEntity<Long> add(@Valid @RequestBody FlatRentEntity bean) {
				Long id = flatrentServ.add(bean);
				return new ResponseEntity<Long>(id, HttpStatus.OK);
			}

			// get flat by PK
			@GetMapping("/getflatsrent/id/{id}")
			public ResponseEntity<FlatRentEntity> findByPk(@PathVariable("id") long id) {
				return new ResponseEntity<FlatRentEntity>(flatrentServ.findByPk(id), HttpStatus.OK);
			}

			// get flats by name
			@GetMapping("/getflatsrent/name/{name}")
			public ResponseEntity<FlatRentEntity> getByName(@Valid @PathVariable("name") String name) {
				return new ResponseEntity<FlatRentEntity>(flatrentServ.findByName(name), HttpStatus.OK);
			}

			// update flats
			@PatchMapping("/updateflatsrent")
			public void update(@Valid @RequestBody FlatRentEntity bean) {
				flatrentServ.update(bean);

			}

			// delete flats
			@DeleteMapping("/flatsrent")
			public void delete(@RequestBody FlatRentEntity bean) {
				flatrentServ.delete(bean);
			}
			
			//get page
			
			@PostMapping("/flatrent/{pageNo}/{pageSize}")
			public ResponseEntity<List<FlatRentEntity>> getDeliveries(@PathVariable Integer pageNo,@PathVariable Integer pageSize,@RequestBody FlatRentEntity bean){
				List<FlatRentEntity> al= flatrentServ.search(bean,pageNo,pageSize);
				return new ResponseEntity<>(al,HttpStatus.OK);
			}

}
