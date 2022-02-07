package com.chester.victor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chester.victor.model.Pet;
import com.chester.victor.services.PetService;

@RestController
@RequestMapping("/mascotas")
public class PetRestController
{
	@Autowired
	PetService petService;
	
	
	@GetMapping(value="/", produces = "Application/JSON")
	public @ResponseBody  List<Pet> getMascotas()
	{
		return petService.getAllPets();
	}
	
		
	@PutMapping(value="/", produces = "Application/JSON")
	public @ResponseBody Pet updMascotas(Pet pet)
	{
		return petService.upd(pet);
	}
	
	
	@PostMapping(value="/", produces = "Application/JSON")
	public @ResponseBody Pet addMascotas(Pet pet)
	{
		return petService.add(pet);
	}	
	
	@DeleteMapping(value="/", produces = "Application/JSON")
	public @ResponseBody boolean delMascotas(Pet pet)
	{
		return petService.del(pet);
	}	
	
	
	@GetMapping(value="/enferma", produces = "Application/JSON")
	public @ResponseBody Iterable<Pet> getMascotaEnfermas( )
	{
		return petService.getMascotasEnfermas();
	}	
	
	
	@GetMapping(value="/porNombre", produces = "Application/JSON")
	public @ResponseBody Iterable<Pet> getMascotasPorNombre(@RequestParam("nombre") String nombre)
	{
		return petService.getPorNombre(nombre); 
	}	
	
				
}
