package com.fmg.example1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profile {
    @Id
    @GeneratedValue
    @Column(name="profile_id")
    private Long id;

    private String address;
    private String phoneNumber;
	public Profile() {
		super();
	}
	
	public Profile(Long id) {
		super();
		this.id = id;
	}

	public Profile(String address, String phoneNumber) {
		super();
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    // Getters and Setters
    
}
