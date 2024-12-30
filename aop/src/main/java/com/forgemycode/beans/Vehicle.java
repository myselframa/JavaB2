package com.forgemycode.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.forgemycode.service.VehicleService;


@Component
public class Vehicle {
	
	private String name="Audi";
	
	private VehicleService vehicleService;

	@Autowired
	public Vehicle(VehicleService vehicleService) {
		super();
		this.vehicleService = vehicleService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", vehicleService=" + vehicleService + "]";
	}

	public void printHello(){
        System.out.println(
            "Printing Hello from Component Vehicle Bean");
    }


}
