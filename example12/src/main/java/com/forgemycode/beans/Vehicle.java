package com.forgemycode.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Vehicle {
	
	private String name;

	public Vehicle() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + "]";
	}
	
	public void printHello(){
        System.out.println(
            "Printing Hello from Component Vehicle Bean");
    }


}
