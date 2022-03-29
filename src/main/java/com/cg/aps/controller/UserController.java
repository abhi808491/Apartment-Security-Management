package com.cg.aps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.aps.dto.RegisterUserRequest;
import com.cg.aps.dto.UpdateUserPasswordRequest;
import com.cg.aps.entity.UserEntity;

import com.cg.aps.service.UserServiceInt;
import java.util.List;

import javax.validation.Valid;

@RestController

public class UserController {
	@Autowired
	UserServiceInt userServ;

	// searching Users
	@PostMapping("/searchUsers")
	public ResponseEntity<List<UserEntity>> search(@RequestBody UserEntity bean) {
		List<UserEntity> al = userServ.search(bean);
		return new ResponseEntity<>(al, HttpStatus.OK);
	}

	// add Users
	@PostMapping("/addUsers")
	public ResponseEntity<Long> add(@Valid @RequestBody UserEntity bean) {
		Long id = userServ.add(bean);
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}

	// get users by PK
	@GetMapping("/getusersbyId/{id}")
	public ResponseEntity<UserEntity> findByPk(@PathVariable("id") long id) {
		return new ResponseEntity<UserEntity>(userServ.findByPk(id), HttpStatus.OK);
	}

	// get users by login
	@GetMapping("/getusersbyLogin/{login}")
	public ResponseEntity<UserEntity> getByLogin(@Valid @PathVariable("login") String Login) {
		return new ResponseEntity<UserEntity>(userServ.findByLogin(Login), HttpStatus.OK);
	}

	// update users
	@PatchMapping("/updateUsers")

	public ResponseEntity<UserEntity> update(@RequestBody UserEntity bean) {
		userServ.update(bean);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// delete users
	@DeleteMapping("/deleteUsers")
	public ResponseEntity<UserEntity> delete(@RequestBody UserEntity bean) {
		userServ.delete(bean);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	// update password

	@PutMapping("/updatePassword")

	public ResponseEntity<Boolean> updateUserPassword(@RequestBody UpdateUserPasswordRequest request) {
		userServ.changePassword(request.getId(), request.getOldPassword(), request.getNewPassword());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
   //pagination
	
	@PostMapping("/user/{pageNo}/{pageSize}")
	public ResponseEntity<List<UserEntity>> getDeliveries(@PathVariable Long pageNo, @PathVariable Integer pageSize) {
		List<UserEntity> al = userServ.search(pageNo, pageSize);
		return new ResponseEntity<>(al, HttpStatus.OK);
	}

	// Register user
	@PostMapping("/loginAdmin")
	public ResponseEntity<String> registerUser(@RequestBody RegisterUserRequest request) {
		userServ.registerUser(request);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//AddGard with userPk(Relationship)
	@GetMapping("/addGard/{userPk}/{gardPk}")
	public UserEntity addGard(@PathVariable("userPk") long userPk,@PathVariable("gardPk") long gardPk) {
		return userServ.addGard(userPk, gardPk);
	}
	//AddFlat with userPk(Relationship)
	@GetMapping("/addFlat/{userPk}/{flatPk}")
	public UserEntity addFlat(@PathVariable("userPk") long userPk,@PathVariable("flatPk") long flatPk) {
		return userServ.addFlat(userPk, flatPk);
	}
	//AddVehicle with userPk(Relationship)
	@GetMapping("/addVehicle/{userPk}/{vehiclePk}")
	public UserEntity addVehicle(@PathVariable("userPk") long userPk,@PathVariable("vehiclePk") long vehiclePk) {
		return userServ.addVehicle(userPk, vehiclePk);
	}


}
	
