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
import com.cg.aps.entity.VisitorEntity;
import com.cg.aps.service.VisitorServiceInt;

@RestController
public class VisitorController {

	@Autowired
	VisitorServiceInt visServ;
	
	@PostMapping("/addVisitor")
	public ResponseEntity<Long> addVisitor(@RequestBody VisitorEntity visitor) {
			long visitorId = visServ.addVisitor(visitor);
			return new ResponseEntity<>(visitorId,HttpStatus.OK);
		}
	
	@GetMapping("/visitor/{visitorId}")
	public ResponseEntity<VisitorEntity> getVisitorById(@PathVariable long visitorId){
		
			VisitorEntity visitor = visServ.findByPk(visitorId);
			return new ResponseEntity<>(visitor,HttpStatus.OK);
}
	
	@GetMapping("/visitor")
	public ResponseEntity<List<VisitorEntity>> getAllVisitors(@RequestBody VisitorEntity visitor){	
			List<VisitorEntity> visitorList = visServ.search(visitor);
			return new ResponseEntity<>(visitorList,HttpStatus.OK);
}
	@GetMapping("/visitor/{pageNo}/{pageSize}")
	public ResponseEntity<List<VisitorEntity>> getVisitors(@PathVariable Integer pageNo,@PathVariable Integer pageSize){
			List<VisitorEntity> visitorList = visServ.search(pageNo, pageSize);
			return new ResponseEntity<>(visitorList,HttpStatus.OK);
		}
	
	@PutMapping("/updateVisitor")
	public ResponseEntity<String> updateVisitor(@RequestBody VisitorEntity visitor) {
			visServ.updateVisitor(visitor);
			return new ResponseEntity<>("updated successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/visitor/{id}")
	public ResponseEntity<String> deleteVisitor(@PathVariable Long id) {
			VisitorEntity visitor = visServ.findByPk(id);
			visServ.deleteVisitor(visitor);
			return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
		}	
	@GetMapping("visitorByFlat/{flatId}")
	ResponseEntity<List<VisitorEntity>> getVisitorByFlatId(@PathVariable("flatId") Long flatId)
	{
		List<VisitorEntity> lis= visServ.getVisitorByFlatId(flatId);
		return new ResponseEntity<>(lis, HttpStatus.OK);
		
	}
	@GetMapping("/VisitorToFlat/{visitorId}/{flatId}")
	public ResponseEntity<VisitorEntity> addFlat(@PathVariable Long visitorId,@PathVariable Long flatId){
			VisitorEntity visitor = visServ.addFlatRelationship(visitorId, flatId);
			return new ResponseEntity<>(visitor,HttpStatus.OK);
}
	@GetMapping("/VisitorRelationship/{visitorId}/{gardId}/{flatId}")
	public ResponseEntity<VisitorEntity> addgard(@PathVariable Long visitorId,@PathVariable Long gardId,@PathVariable Long flatId){
			VisitorEntity visitor = visServ.addRelationship(visitorId, gardId,flatId);
			return new ResponseEntity<>(visitor,HttpStatus.OK);
}	
	@GetMapping("visitorByGardId/{gardId}")
	ResponseEntity<List<VisitorEntity>> getVisitorByGardId(@PathVariable("gardId") Long gardId)
	{
		List<VisitorEntity> lis= visServ.getVisitorByGardId(gardId);
		return new ResponseEntity<>(lis, HttpStatus.OK);
	}
}
