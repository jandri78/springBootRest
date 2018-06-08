package com.andres;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class AlienResource 
{
	@Autowired
	AlienRepository repo;
	
	@GetMapping("aliens")
	public List<Alien> getAliens()
	{
		
		List<Alien> aliens = (List<Alien>) repo.findAll();

	 return aliens;
	}
	
	@GetMapping("aliens/{id}")
	public Alien getAlien(@PathVariable int id){
		System.out.println("one alien");
		Alien aliens =  repo.findOne(id);
		
		return aliens;
	}
	
	@RequestMapping(value = "aliens",method=RequestMethod.POST)
	public Alien createAliens(@Valid @RequestBody Alien a)
	{
		System.out.println(a);
		Alien aliens =  repo.save(a);
		

	return aliens;
	}
	
	@RequestMapping(value = "aliens",method=RequestMethod.PUT)
	public Alien updateAlien(@Valid @RequestBody Alien a){
		
		
		Alien aliens2 =  repo.findOne(a.getId());
		Alien aliens = null;
		
		if (aliens2 != null) {
			System.out.println("el registro existe");
			return aliens =  repo.save(a);
		}else {
			System.out.println("No se puede hacer update");
			aliens = new Alien();
			aliens.setName("No se puede hacer update");
			return aliens;
		}
		
	}
	
	/**
	@RequestMapping(value = "aliens",method=RequestMethod.DELETE)
	public Alien deleteAlien(@Valid @RequestBody Alien a){
		
		 Alien alien = repo.delete(a);

		return alien;
	}**/
	

	
}
