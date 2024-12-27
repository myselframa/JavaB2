package com.forgemycode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.forgemycode.beans.Person;
import com.forgemycode.beans.Vehicle;

/*
Spring @Configuration annotation is part of the spring core framework.
Spring Configuration annotation indicates that the class has @Bean definition
methods. So Spring container can process the class and generate Spring Beans
to be used in the application.
* */
@Configuration

public class ProjectConfig {
	
	@Bean
	Vehicle vehicle() {
		Vehicle vehicle=new Vehicle();
		vehicle.setName("Audi");
		return vehicle;
	}
	
	//way one by using method name
	/*
	 * @Bean Person person() { Person person=new Person(); person.setName("Rama");
	 * person.setVehicle(vehicle()); return person;
	 * 
	 * }
	 */
	
	@Bean
	Person person(Vehicle vehicle) {
		Person person=new Person();
		person.setName("Rama");
		person.setVehicle(vehicle);
		return person;
		
	}

}
