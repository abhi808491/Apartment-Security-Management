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
import org.springframework.web.server.ResponseStatusException;

import com.cg.aps.entity.SecurityEntity;
import com.cg.aps.entity.VisitorEntity;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.service.SecurityServiceInt;


@RestController
public class SecurityController {
	@Autowired
	SecurityServiceInt secServ;
	
	@PostMapping("/addSecurity")
	public ResponseEntity<Long> add(@RequestBody SecurityEntity security) {
			Long alertId = secServ.add(security);
			return new ResponseEntity<>(alertId,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateSecurity")
	public ResponseEntity<String> updating(@RequestBody SecurityEntity security) {
			secServ.update(security);
			return new ResponseEntity<>("updated successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteSecurity")
	public ResponseEntity<String> deletesec(@PathVariable Integer id) {
			SecurityEntity sec = secServ.findByPk(id);
			secServ.delete(sec);
			return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
	}
	
	@GetMapping("/Security/{Id}")
	public ResponseEntity<SecurityEntity> getAlertById(@PathVariable Integer Id){
			SecurityEntity sec = secServ.findByPk(Id);
			return new ResponseEntity<>(sec,HttpStatus.OK);
	}
	
	@GetMapping("/Security/search")
	public ResponseEntity<List<SecurityEntity>> getAllAlerts(@RequestBody SecurityEntity sec){
			List<SecurityEntity> secList = secServ.search(sec);
			return new ResponseEntity<>(secList,HttpStatus.OK);
	}
	
	@GetMapping("/Security/{pageNo}/{pageSize}")
	public ResponseEntity<List<SecurityEntity>> getAlerts(@RequestBody SecurityEntity sec, @PathVariable Integer pageNo,@PathVariable Integer pageSize){
			List<SecurityEntity> alertList = secServ.search(sec, pageNo, pageSize);
			return new ResponseEntity<>(alertList,HttpStatus.OK);
		
	}
	
	@GetMapping("SecurityByGard/{gardId}")
	ResponseEntity<List<SecurityEntity>> getSecurityByGardId(@PathVariable("gardId") Long gardId)
	{
		List<SecurityEntity> lis= secServ.getSecurityByGard(gardId);
		return new ResponseEntity<>(lis, HttpStatus.OK);
		
	}
	
	@GetMapping("/SecurityToGard/{securityId}/{gardId}")
	public ResponseEntity<SecurityEntity> addRelation(@PathVariable Long securityId,@PathVariable Long gardId){
			SecurityEntity security = secServ.addRelation(securityId, gardId);
			return new ResponseEntity<>(security,HttpStatus.OK);
}
	
	
		
}
