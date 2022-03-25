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

import com.cg.aps.entity.GardShiftEntity;
import com.cg.aps.entity.GardsTranningEntity;
import com.cg.aps.service.GardsTranningServiceInt;
@RestController
public class GardsTranningController {
	@Autowired
	GardsTranningServiceInt gardsTranningServ;
	
	//search gard
	@PostMapping("/searchgards")
	public GardsTranningEntity search(@RequestBody GardsTranningEntity bean)
	{
		return gardsTranningServ.search(bean);
	}
	
	// add gards
	@PostMapping("/addgards")
	public long add(@RequestBody GardsTranningEntity bean)
	{
		gardsTranningServ.add(bean);
		return bean.getUserId();
	}
	
	//get gards by PK
	@GetMapping("/getgards/id/{id}")
	public GardsTranningEntity findByPk(@PathVariable("id") long id)
	{
		return gardsTranningServ.findByPk(id);
	}
	//get gards by name
	@GetMapping("/getgards/name/{name}")
	public GardsTranningEntity getByName(@PathVariable("name") String name)
	{
		return gardsTranningServ.getByName(name);
	}
	
	//update gards
	@PatchMapping("/updategards")
	public void update(@RequestBody GardsTranningEntity bean)
	{
		gardsTranningServ.update(bean);
	}
	
	//delete gards
	@DeleteMapping("/gards")
	public void delete(@RequestBody GardsTranningEntity bean)
	{
		gardsTranningServ.delete(bean);
	}
	
	

}
