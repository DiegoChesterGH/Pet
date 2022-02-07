package com.chester.victor.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.chester.victor.model.Pet;

public class PetRepositoryCustomImpl implements PetRepositoryCustom
{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Iterable<Pet> getPetByName(String nombre) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pet> query = cb.createQuery(Pet.class);
		Root<Pet> root = query.from(Pet.class);
		
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.like(root.get("nombre"), "%"+nombre+"%"));
		query.select(root).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
		
		return entityManager.createQuery(query).getResultList();
	}
	

}
