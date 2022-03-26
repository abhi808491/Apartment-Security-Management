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
import com.cg.aps.entity.GardsTranningEntity;
import com.cg.aps.service.GardsTranningServiceInt;

@RestController
public class GardsTranningController {
	@Autowired
	GardsTranningServiceInt gardsTranningServ;

	// search gard
	@PostMapping("/searchgards")
	public ResponseEntity<List<GardsTranningEntity>> search(@RequestBody GardsTranningEntity bean) {
		List<GardsTranningEntity> al = gardsTranningServ.search(bean);
		return new ResponseEntity<>(al, HttpStatus.OK);
	}

	// add gards
	@PostMapping("/addgards")
	public ResponseEntity<Long> add(@Valid @RequestBody GardsTranningEntity bean) {
		Long id = gardsTranningServ.add(bean);
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}

	// get gards by PK
	@GetMapping("/getgards/id/{id}")
	public ResponseEntity<GardsTranningEntity> findByPk(@PathVariable("id") long id) {
		return new ResponseEntity<GardsTranningEntity>(gardsTranningServ.findByPk(id), HttpStatus.OK);
	}

	// get gards by name
	@GetMapping("/getgards/name/{name}")
	public ResponseEntity<GardsTranningEntity> getByName(@Valid @PathVariable("name") String name) {
		return new ResponseEntity<GardsTranningEntity>(gardsTranningServ.getByName(name), HttpStatus.OK);
	}

	// update gards
	@PatchMapping("/updategards")
	public void update(@Valid @RequestBody GardsTranningEntity bean) {
		gardsTranningServ.update(bean);

	}

	// delete gards
	@DeleteMapping("/gards")
	public void delete(@RequestBody GardsTranningEntity bean) {
		gardsTranningServ.delete(bean);
	}
	
	//get page
	
	@PostMapping("/delivery/{pageNo}/{pageSize}")
	public ResponseEntity<List<GardsTranningEntity>> getDeliveries(@PathVariable Integer pageNo,@PathVariable Integer pageSize,@RequestBody GardsTranningEntity bean){
		List<GardsTranningEntity> al= gardsTranningServ.search(bean,pageNo,pageSize);
		return new ResponseEntity<>(al,HttpStatus.OK);
	}

}
