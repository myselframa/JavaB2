package com.forgemycode.beans;

import org.springframework.stereotype.Component;

@Component
public class BridgeStoneTyres implements Tyre{

	public void rotate() {
		System.out.println("BridgeStoneTyres forwarded");
	}

}
