package com.cg.aps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.aps.entity.GardSalaryEntity;
import com.cg.aps.service.GardSalaryServiceInt;

@RestController
public class GardSalaryController {
	@Autowired
	GardSalaryServiceInt gardSalaryServ;
	
	//seraching  gard
		@PostMapping("/getgards")
		public GardSalaryEntity search(@RequestBody GardSalaryEntity bean)
		{
			return gardSalaryServ.search(bean);
		}
	
	//add gards
	@PostMapping("/addgard")
	public long add(@RequestBody GardSalaryEntity bean)
	{
		return gardSalaryServ.add(bean);
	}
	//get gards by PK
		@GetMapping("/getgardsbyId/{id}")
		public GardSalaryEntity findByPk(@PathVariable("id") long id)
		{
			return gardSalaryServ.findByPk(id);
		}
		//get gards by name
		@GetMapping("/getgardsbyname/{name}")
		public GardSalaryEntity getByName(@PathVariable("name") String name)
		{
			return gardSalaryServ.findByName(name);
		}
		
		//update gards
		@PatchMapping("/updategard")
		public void update(@RequestBody GardSalaryEntity bean)
		{
			gardSalaryServ.update(bean);
		}
		
		//delete gards
		@DeleteMapping("/deletegard")
		public void delete(@RequestBody  GardSalaryEntity bean)
		{
			gardSalaryServ.delete(bean);
		}
		
		
}
