package com.forgemycode.beans;

import org.springframework.stereotype.Component;

@Component
public class MichelinTyres implements Tyre{

	public void rotate() {
		System.out.println("MichelinTyres : Forward ");
	}
}
