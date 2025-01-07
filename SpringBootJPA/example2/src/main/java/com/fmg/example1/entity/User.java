package com.fmg.example1.entity;
                                                                                                                       
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;                                                                                                                   
                                                                                                                                                       
@Entity 
@Table(name="user_tb")
public class User {                                                                                                                                    
    @Id                                                                                                                                                
    @GeneratedValue                                                                                                                                    
    private Long id;                                                                                                                                   
                                                                                                                                                       
    private String name;                                                                                                                               
                                                                                                                                                       
    @OneToOne(cascade = CascadeType.ALL) // Cascade relationship                                                                                       
    @JoinColumn(name = "profile_id") // Defines the foreign key column                                                                                 
    private Profile profile;                                                                                                                           
      
    
    public User() {                                                                                                                                    
    	super();                                                                                                                                       
    } 
	public User(Long id) {                                                                                                                             
		super();                                                                                                                                       
		this.id = id;                                                                                                                                  
	}                                                                                                                                                  
                                                                                                                                                       
	public User( String name, com.fmg.example1.entity.Profile profile2) {                                                                              
		super();                                                                                                                                                                                                                                                                                     
		this.name = name;                                                                                                                              
		this.profile = profile2;                                                                                                                       
	}                                                                                                                                                  
                                                                                                                                                    
                                                                                                                                                       
	public Long getId() {                                                                                                                              
		return id;                                                                                                                                     
	}                                                                                                                                                  
                                                                                                                                                       
	public void setId(Long id) {                                                                                                                       
		this.id = id;                                                                                                                                  
	}                                                                                                                                                  
                                                                                                                                                       
	public String getName() {                                                                                                                          
		return name;                                                                                                                                   
	}                                                                                                                                                  
                                                                                                                                                       
	public void setName(String name) {                                                                                                                 
		this.name = name;                                                                                                                              
	}                                                                                                                                                  
                                                                                                                                                       
	public Profile getProfile() {                                                                                                                      
		return profile;                                                                                                                                
	}                                                                                                                                                  
                                                                                                                                                       
	public void setProfile(Profile profile) {                                                                                                          
		this.profile = profile;                                                                                                                        
	}                                                                                                                                                  
                                                                                                                                                       
                                                                                                                                                       
}                                                                                                                                                      
                                                                                                                                                       