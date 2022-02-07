package com.chester.victor.repositories;

import com.chester.victor.model.Pet;

public interface PetRepositoryCustom 
{
	
	Iterable<Pet> getPetByName( String nombre );
	
}
