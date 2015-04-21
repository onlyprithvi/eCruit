package edu.mum.cs544.project.ecruit.convertTotxt.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Education {
	@Id
	@GeneratedValue
	int id;

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
