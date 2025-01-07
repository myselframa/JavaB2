package com.fmg.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fmg.example1.entity.Profile;
import com.fmg.example1.entity.User;
import com.fmg.example1.entity.UserRepo;

@SpringBootApplication
public class Example2Application implements CommandLineRunner {

	@Autowired
	private UserRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(Example2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/* 1.*****************Save *******************/
		// 1. Method
		Profile pr1=new Profile("bnglr","1234");
		User usr=new User("Ram", pr1);
		repo.save(usr);
	}

}
