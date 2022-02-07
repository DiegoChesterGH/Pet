package com.chester.victor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chester.victor.model.Pet;
import com.chester.victor.repositories.PetRepository;

@Service
public class PetService 
{
	@Autowired
	PetRepository petRepository;
	
	public List<Pet> getAllPets() 
	{
		return petRepository.findAll();
	}



	public Pet upd(Pet petNuevo) {
	
		Optional<Pet> optPet = petRepository.findById(petNuevo.getId());
		Pet petActual = optPet.get();
		
		//			.orElseThrow(() -> new PetNotFoundException( "Mascota id="+petNuevo.getId() + ", No se realizó la actualización"));
	
		petActual.setNombre(petNuevo.getNombre());
		petActual.setSalud(petNuevo.getSalud());
		
		return petRepository.save(petActual);
	}



	public Pet add(Pet pet) {
		return petRepository.save(pet);
	}



	public boolean del(Pet pet) {
		
		Optional<Pet> optPet = petRepository.findById(pet.getId());
		Pet petFind = optPet.get(); // este arroja excepcions si no lo encuentra
		 
		petRepository.deleteById(petFind.getId());
		return true;
		 
	}



	public Iterable<Pet> getMascotasEnfermas() {
		// TODO Auto-generated method stub
		return petRepository.getSickPets();
	}



	public Iterable<Pet> getPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return petRepository.getPetByName(nombre);
	}
	
	


}
