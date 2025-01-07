package com.fmg.example1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id") // Foreign key column in the Employee table
    private Departement department;

	public Employee() {
		super();
	}

	public Employee(String name, Departement department) {
		super();
		this.name = name;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Departement getDepartment() {
		return department;
	}

	public void setDepartment(Departement department) {
		this.department = department;
	}
   
    
}

