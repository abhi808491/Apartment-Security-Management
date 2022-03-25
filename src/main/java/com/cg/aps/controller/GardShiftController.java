package com.cg.aps.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.aps.entity.GardShiftEntity;
import com.cg.aps.entity.GardsTranningEntity;
import com.cg.aps.service.GardShiftServiceInt;

@RestController
public class GardShiftController {
	@Autowired
	GardShiftServiceInt gardShiftServ;
	
	//add new gard
	@PostMapping("/addgardshift")
	public long add(@RequestBody GardShiftEntity bean)
	{
		gardShiftServ.add(bean);
		return bean.getId();
	}
	//search gard
	@PostMapping("/searchgard")
	public GardShiftEntity search(@RequestBody GardShiftEntity bean)
	{
		return gardShiftServ.search(bean);
	}
	
	//get gard bypk
	@GetMapping("/getgard/pk/{id}")
	public GardShiftEntity findByPk(@PathVariable("id") long id)
	{
		return gardShiftServ.findByPk(id);
	}
	
	//get by name
	@GetMapping("/getgard/name/{name}")
	public GardShiftEntity findByName(@PathVariable("name") String name)
	{
		return gardShiftServ.getByName(name);
	}
	
	//update gard
	@PatchMapping("/updategardshift")
	public void update(@RequestBody GardShiftEntity bean)
	{
		gardShiftServ.update(bean);
	}
	
	//delete gard
	@DeleteMapping("/deletegards")
	public void delete(@RequestBody GardShiftEntity bean)
	{
		gardShiftServ.delete(bean);
	}
	
	

}
