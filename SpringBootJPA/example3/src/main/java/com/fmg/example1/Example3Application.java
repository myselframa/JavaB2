package com.fmg.example1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fmg.example1.entity.Departement;
import com.fmg.example1.entity.DepartmentRepo;
import com.fmg.example1.entity.Employee;

@SpringBootApplication
public class Example3Application implements CommandLineRunner {

	@Autowired
	private DepartmentRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(Example3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Departement sales = new Departement(); 
		sales.setName("Sales"); 
		Departement it = new Departement(); 
		it.setName("IT"); 
		// Create Customers 
		Employee emp1 = new Employee(); 
		emp1.setName("John Doe"); 
		emp1.setDepartment(sales); 
		
		Employee emp2 = new Employee();
		emp2.setName("Jane Smith"); 
		emp2.setDepartment(sales); 
		Employee emp3 = new Employee(); 
		emp3.setName("Alice Johnson"); 
		emp3.setDepartment(it); 
		// Set Customers to Departments 
		sales.setEmployees(Arrays.asList(emp1, emp2)); 
		it.setEmployees(Arrays.asList(emp3)); 
		// Save to Database 
		repo.saveAll(Arrays.asList(sales, it));
	}

}
