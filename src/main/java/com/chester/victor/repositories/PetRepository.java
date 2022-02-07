package com.chester.victor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chester.victor.model.Pet;


//de esta manera creo un repositorio, que en concreto es crear la tabla y el vinculo con SPRING
public interface PetRepository extends JpaRepository<Pet, Integer>, PetRepositoryCustom
{
	
	@Query(value = "select FROM MASCOTAS m WHERE m.salud < 50", nativeQuery = true)
	Iterable<Pet> getSickPets();
	
	
	
}