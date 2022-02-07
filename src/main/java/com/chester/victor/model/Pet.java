package com.chester.victor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
@Table (name = "mascotas")
public class Pet 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
		
	@NotNull(message = "El nombre de la mascota no debe ser vacio")
	private String nombre;
	
	@Range(min=1, max=100, message = "El valor de salud debe estar entr1e 1 y 100")
	private Integer salud;
	
	public Pet() // se debe crear siempre el contructor por defecto en JPA
	{
	
	}
	
	
	
	public Integer getSalud() 
	{
		return salud;
	}


	public void setSalud(Integer salud) {
		this.salud = salud;
	}


	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
