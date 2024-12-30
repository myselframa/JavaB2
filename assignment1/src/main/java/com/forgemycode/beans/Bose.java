package com.forgemycode.beans;

import org.springframework.stereotype.Component;

@Component
public class Bose implements Speaker{

	public void makeSound() {
		System.out.println("Music from Bose");
	}
}
