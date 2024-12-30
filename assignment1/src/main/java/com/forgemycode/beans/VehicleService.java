package com.forgemycode.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VehicleService {

	private Speaker speaker;
	private Tyre tyre;
	@Autowired
	public VehicleService(@Qualifier("sony")  Speaker speaker,@Qualifier("bridgeStoneTyres") Tyre tyre) {
		super();
		this.speaker = speaker;
		this.tyre = tyre;
	}
	
	public void playMusic() {
		speaker.makeSound();
	}
	
	public void moveForward() {
		tyre.rotate();
	}

	@Override
	public String toString() {
		return "VehicleService [speaker=" + speaker + ", tyre=" + tyre + "]";
	}
	
	
}
