package com.forgemycode.beans;

import org.springframework.stereotype.Component;

@Component
public class Sony implements Speaker{

	@Override
	public void makeSound() {
		System.out.println("Play music Sony");
		
	}

}
